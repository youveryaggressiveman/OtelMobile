package com.example.otel.controller

import com.example.otel.models.*
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import kotlinx.coroutines.*
import java.io.Serializable
import java.net.UnknownServiceException
import java.util.*
import kotlin.coroutines.CoroutineContext

class AuthorizeController: CoroutineScope {

    var job: Job = Job()

    fun getUserByNumber(phoneNumber: String): User? {
        var reqParam =
            URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phoneNumber, "UTF-8")
        val mURL = URL("http://10.200.2.125:80/api/Users/phone?$reqParam")

        var result: String = ""

        with(mURL.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            if(responseCode == 200){
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        result += line
                    }
                }
            }
        }
        return Gson().fromJson(result, User::class.java)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
}