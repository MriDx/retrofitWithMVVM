package com.example.retrofitwithmvvm.network

import com.example.retrofitwithmvvm.data.PostData
import com.example.retrofitwithmvvm.data.UserData
import retrofit2.Response

interface ApiHelper {
    /**
     * write helper function for endpoints
     */
    suspend fun getUsers(): Response<List<UserData>>

    suspend fun getPosts(): Response<List<PostData>>
}