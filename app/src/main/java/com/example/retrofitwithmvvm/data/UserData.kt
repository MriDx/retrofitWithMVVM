package com.example.retrofitwithmvvm.data

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("username") var username: String,
    @SerializedName("email") var email: String,
    @SerializedName("address") var address: AddressData,
    @SerializedName("phone") var phone: String,
    @SerializedName("website") var website: String,
    @SerializedName("company") var company: CompanyData
)
