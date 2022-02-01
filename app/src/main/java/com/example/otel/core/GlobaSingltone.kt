package com.example.otel.core

import com.example.otel.models.Order
import com.example.otel.models.User

class GlobaSingltone {
    companion object{
        var user: User = User()
        var order: Order = Order()
    }

}