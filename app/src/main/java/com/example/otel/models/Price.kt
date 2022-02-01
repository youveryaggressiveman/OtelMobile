package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class Price (

  @SerializedName("Currency"   ) var Currency   : Currency? = Currency(),
  @SerializedName("ID"         ) var ID         : Int?      = null,
  @SerializedName("Number"     ) var Number     : Int?      = null,
  @SerializedName("CurrencyID" ) var CurrencyID : Int?      = null

)