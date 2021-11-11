package com.example.retrofitwithmvvm.data

import com.google.gson.annotations.SerializedName

data class CompanyData(
    @SerializedName("name") var name: String,
    @SerializedName("catchPhrase") var catchPhrase: String,
    @SerializedName("bs") var bs: String
)