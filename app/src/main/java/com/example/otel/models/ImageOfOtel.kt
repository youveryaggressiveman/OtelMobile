package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class ImageOfOtel (

    @SerializedName("ID"     ) var ID     : Int?    = null,
    @SerializedName("Image"  ) var Image  : String? = null,
    @SerializedName("OtelID" ) var OtelID : Int?    = null

)