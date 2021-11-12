package com.example.retrofitwithmvvm.data

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("userId") var userId: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String
)