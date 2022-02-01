package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Hotel (

    @SerializedName("AddressOfOtel"   ) var AddressOfOtel   : AddressOfOtel?    = AddressOfOtel(),
    @SerializedName("Discription"     ) var Discription     : Discription?      = Discription(),
    @SerializedName("ImageOfOtel"     ) var ImageOfOtel     : List<ImageOfOtel> = arrayListOf(),
    @SerializedName("Order"           ) var Order           : List<Order>      = arrayListOf(),
    @SerializedName("Room"            ) var Room            : List<Room>        = arrayListOf(),
    @SerializedName("ID"              ) var ID              : Int?              = null,
    @SerializedName("Name"            ) var Name            : String?           = null,
    @SerializedName("AddressOfOtelID" ) var AddressOfOtelID : Int?              = null,
    @SerializedName("DiscriptionID"   ) var DiscriptionID   : Int?              = null

)