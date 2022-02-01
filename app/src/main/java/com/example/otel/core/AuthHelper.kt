package com.example.otel.core

import android.content.DialogInterface
import android.provider.Settings
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.otel.controller.AuthorizeController
import com.example.otel.models.User
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class AuthHelper: CoroutineScope {
    val job = Job()
     suspend fun Authorize(editPhone: String, editPassword: String): Boolean{
         var authorizeController: AuthorizeController = AuthorizeController()

         var user: User = User()
         var result = this.async {
            authorizeController.getUserByNumber(editPhone)
         }
         this.launch {
             user = result.await()!!
         }

         result.join()

         GlobaSingltone.user = user

         return editPassword == user?.Password && editPhone == user?.Phone
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
}