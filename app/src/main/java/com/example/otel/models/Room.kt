package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Room (

    @SerializedName("Price"      ) var Price      : Price?    = Price(),
    @SerializedName("TypeRoom"   ) var TypeRoom   : TypeRoom? = TypeRoom(),
    @SerializedName("ID"         ) var ID         : Int?      = null,
    @SerializedName("TypeRoomID" ) var TypeRoomID : Int?      = null,
    @SerializedName("Number"     ) var Number     : Int?      = null,
    @SerializedName("PriceID"    ) var PriceID    : Int?      = null,
    @SerializedName("OtelID"     ) var OtelID     : Int?      = null

)