package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class TypeRoom (

  @SerializedName("ID"   ) var ID   : Int?    = null,
  @SerializedName("Name" ) var Name : String? = null

)