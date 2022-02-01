package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Order (

  @SerializedName("Room"          ) var Room          : List<Room> = arrayListOf(),
  @SerializedName("ID"            ) var ID            : Int?       = null,
  @SerializedName("ClientID"      ) var ClientID      : Int?       = null,
  @SerializedName("OtelID"        ) var OtelID        : Int?       = null,
  @SerializedName("ArrivalDate"   ) var ArrivalDate   : String?    = null,
  @SerializedName("DepartureDate" ) var DepartureDate : String?    = null

)