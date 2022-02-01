package com.example.otel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import com.example.otel.R
import com.example.otel.adapter.NumbersViewAdapter
import com.example.otel.controller.OrderController
import com.example.otel.core.GlobaSingltone
import com.example.otel.models.Hotel
import com.example.otel.models.Room
import com.example.otel.models.TypeRoom
import kotlinx.coroutines.*
import java.lang.reflect.Array.get
import kotlin.coroutines.CoroutineContext

class InfoAboutOrder : AppCompatActivity(), CoroutineScope{

    var roomSimpleListView: ListView? = null

    val job = Job()

    override fun onCreate(savedInstanceState: Bundle?){
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_about_order)

        var orderController: OrderController = OrderController()

        val country: TextView = findViewById(R.id.country_text_view)
        val nameOtel: TextView = findViewById(R.id.name_otel_text_view)
        val addressOtel: TextView = findViewById(R.id.address_otel_text_view)
        val arrivalDate: TextView = findViewById(R.id.arrival_date_text_view)
        val departureDate: TextView = findViewById(R.id.departure_date_text_view)



        var hotel: ArrayList<Hotel> = ArrayList()
        var resultHotel = this.async {
            orderController.getOtelByOrderId(GlobaSingltone.order?.ID)
        }

        this.launch {

            var roomNumber: ArrayList<String?> = ArrayList()
            var typeRoom: ArrayList<String?> = ArrayList()

            hotel = resultHotel.await()

            for (i in hotel.indices){
                country.post {
                    country.text = (hotel[i].AddressOfOtel?.Country?.Name)
                }
                addressOtel.post{
                    addressOtel.text = (hotel[i].AddressOfOtel?.Name + ", " + hotel[i].AddressOfOtel?.Number)
                }
                nameOtel.post{
                    nameOtel.text = (hotel[i].Name)
                }
            }
            arrivalDate.text = (GlobaSingltone.order?.ArrivalDate)
            departureDate.text = (GlobaSingltone.order?.DepartureDate)

            for (i in GlobaSingltone.order.Room.indices){
                roomNumber.add("Номер комнаты: " + GlobaSingltone.order!!.Room[i]?.Number)
                typeRoom.add("Тип комнаты: " + GlobaSingltone.order!!.Room[i]?.TypeRoom?.Name)
            }

            roomSimpleListView = findViewById(R.id.roomSimpleListView)
            val arrayAdapter = NumbersViewAdapter(
                this@InfoAboutOrder, roomNumber, typeRoom
            )
            roomSimpleListView?.post{
                roomSimpleListView!!.adapter = arrayAdapter
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job
}