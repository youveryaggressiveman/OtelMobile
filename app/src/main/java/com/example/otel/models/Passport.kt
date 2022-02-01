package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Passport (

  @SerializedName("ID"             ) var ID             : Int?    = null,
  @SerializedName("PassportSerial" ) var PassportSerial : String? = null,
  @SerializedName("PassportNumber" ) var PassportNumber : String? = null

)