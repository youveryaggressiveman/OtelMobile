package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Card (

  @SerializedName("ID"             ) var ID             : Int?    = null,
  @SerializedName("HashCode"       ) var HashCode       : Int?    = null,
  @SerializedName("ClientID"       ) var ClientID       : Int?    = null,
  @SerializedName("LastFourDigits" ) var LastFourDigits : String? = null

)