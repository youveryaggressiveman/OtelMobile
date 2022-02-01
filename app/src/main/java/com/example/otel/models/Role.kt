package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Role (

  @SerializedName("ID"       ) var ID       : Int?    = null,
  @SerializedName("Name"     ) var Name     : String? = null,
  @SerializedName("Discount" ) var Discount : Int?    = null

)