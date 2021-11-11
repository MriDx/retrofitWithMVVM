package com.example.retrofitwithmvvm.network

import com.example.retrofitwithmvvm.data.UserData
import retrofit2.Response

interface ApiHelper {
    suspend fun getEmployees(): Response<List<UserData>>
}