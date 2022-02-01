package com.example.otel.models

import com.google.gson.annotations.SerializedName


data class User (

  @SerializedName("Card"       ) var Card       : List<Card> = arrayListOf(),
  @SerializedName("Country"    ) var Country    : Country?     = Country(),
  @SerializedName("Order"      ) var Order      : List<Order> = arrayListOf(),
  @SerializedName("Passport"   ) var Passport   : Passport?    = Passport(),
  @SerializedName("Role"       ) var Role       : Role?        = Role(),
  @SerializedName("ID"         ) var ID         : Int?         = null,
  @SerializedName("SecondName" ) var SecondName : String?      = null,
  @SerializedName("FirstName"  ) var FirstName  : String?      = null,
  @SerializedName("LastName"   ) var LastName   : String?      = null,
  @SerializedName("Phone"      ) var Phone      : String?      = null,
  @SerializedName("Password"   ) var Password   : String?      = null,
  @SerializedName("CountryID"  ) var CountryID  : Int?         = null,
  @SerializedName("PassportID" ) var PassportID : Int?         = null,
  @SerializedName("RoleID"     ) var RoleID     : Int?         = null,
  @SerializedName("Avatar"     ) var Avatar     : String?      = null
)