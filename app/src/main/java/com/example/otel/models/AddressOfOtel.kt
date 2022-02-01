package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class AddressOfOtel (

    @SerializedName("Country"         ) var Country         : Country? = Country(),
    @SerializedName("ID"              ) var ID              : Int?     = null,
    @SerializedName("Number"          ) var Number          : Int?     = null,
    @SerializedName("Name"            ) var Name            : String?  = null,
    @SerializedName("CountryOfOtelID" ) var CountryOfOtelID : Int?     = null

)