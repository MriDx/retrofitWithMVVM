package com.example.retrofitwithmvvm.network

import com.example.retrofitwithmvvm.data.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    /**
     * write all endpoints here
     */

    @GET("users")
    suspend fun getUsers(): Response<List<UserData>>

}