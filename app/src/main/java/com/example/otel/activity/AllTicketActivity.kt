package com.example.otel.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.example.otel.adapter.NumbersViewAdapter
import com.example.otel.controller.AuthorizeController
import com.example.otel.controller.OrderController
import com.example.otel.core.GlobaSingltone
import com.example.otel.models.Order
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import kotlin.coroutines.CoroutineContext
import android.widget.AdapterView.OnItemClickListener
import com.example.otel.R
import org.w3c.dom.Text


class AllTicketActivity : AppCompatActivity(), CoroutineScope {
    var simpleListView: ListView? = null

    val job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_all_ticket)

        var orderController: OrderController = OrderController()

        val name:TextView = findViewById(R.id.name_text_view)
        val phone:TextView = findViewById(R.id.phone_text_view)

        name.text = GlobaSingltone.user?.FirstName
        phone.text = GlobaSingltone.user?.Phone

        var orderList: ArrayList<Order> = ArrayList<Order>()

        var result = this.async {
            orderController.getOrderByUserId(GlobaSingltone.user?.ID)
        }

        this.launch {
            orderList = result.await() as ArrayList<Order>

            var orderId: ArrayList<String?> = ArrayList()
            var orderDepartureDate: java.util.ArrayList<String?> = ArrayList()

            for (i in 0 until orderList.size){
                orderId.add("Билет #" + orderList[i].ID.toString())
                orderDepartureDate.add("Действителен до:" + orderList[i].DepartureDate)
            }

            simpleListView = findViewById<View>(R.id.simpleListView) as ListView
            val arrayAdapter = NumbersViewAdapter(
                this@AllTicketActivity, orderId, orderDepartureDate
            )
            simpleListView?.post{
                simpleListView!!.adapter = arrayAdapter

            }

        }
        simpleListView = findViewById<View>(R.id.simpleListView) as ListView
        simpleListView?.onItemClickListener = OnItemClickListener { parent, v, position, id -> // по позиции получаем выбранный элемент
            // установка текста элемента TextView
            GlobaSingltone.order = orderList[id.toInt()]
            var intent: Intent = Intent(this@AllTicketActivity, InfoAboutOrder::class.java)
            startActivity(intent)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
}