package com.example.otel.controller

import com.example.otel.models.Hotel
import com.example.otel.models.Order
import com.example.otel.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import kotlin.coroutines.CoroutineContext

class OrderController : CoroutineScope {

    var job:Job = Job()

    fun getOrderByUserId(id: Int?): List<Order> {
        var reqParam = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id.toString(), "UTF-8")
        val mURL = URL("http://10.200.2.125:80/api/Orders/user?$reqParam")

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

        var resultFromWebApi: List<Order> = Gson().fromJson(result, object : TypeToken<List<Order>>() {}.type)

        return resultFromWebApi
    }

    fun getOtelByOrderId(id: Int?): ArrayList<Hotel> {
        var reqParam = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id.toString(), "UTF-8")
        val mURL = URL("http://10.200.2.125:80/api/Otels/order?$reqParam")

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

        var resultFromWebApi: ArrayList<Hotel> = Gson().fromJson(result, object : TypeToken<ArrayList<Hotel>>() {}.type)

        return resultFromWebApi
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
}