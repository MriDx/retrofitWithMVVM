package com.example.retrofitwithmvvm.network

import com.example.retrofitwithmvvm.data.UserData
import retrofit2.Response

interface ApiHelper {
    /**
     * write helper function for endpoints
     */
    suspend fun getUsers(): Response<List<UserData>>
}