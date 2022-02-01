package com.example.otel.activity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.otel.R
import com.example.otel.controller.AuthorizeController
import com.example.otel.core.AuthHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    val positiveButtonclick ={dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

    }

    fun ShowAllTicket(view: View){
        val editPhone: EditText = findViewById(R.id.editTextPhone)
        val editPassword: EditText = findViewById(R.id.editTextPassword)
        val authorize: AuthHelper = AuthHelper()
        val button:Button = findViewById(R.id.button_authorize)

        button.post{
            button.isEnabled = false
        }
        launch {
            val isAuth = authorize.Authorize(editPhone.text.toString(), editPassword.text.toString())
            if(isAuth){
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Проверка данных")
                builder.setMessage("Добро пожаловать!")
                builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonclick))
                builder.show()
                val intent: Intent = Intent(this@MainActivity, AllTicketActivity :: class.java)
                startActivity(intent)
                button.post{
                    button.isEnabled = true
                }

            }
            else {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Проверка данных")
                builder.setMessage("Такого пользователя не существует")
                builder.setPositiveButton(
                    "OK",
                    DialogInterface.OnClickListener(function = positiveButtonclick)
                )
                button.post{
                    button.isEnabled = true
                }
                builder.show()
            }
        }



    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO


}