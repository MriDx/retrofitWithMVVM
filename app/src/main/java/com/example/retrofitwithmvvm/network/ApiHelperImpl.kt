package com.example.retrofitwithmvvm.network

import com.example.retrofitwithmvvm.data.PostData
import com.example.retrofitwithmvvm.data.UserData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    /**
     * extend ApiHelper to get apiService injected
     * calling actual api from here
     */

    override suspend fun getUsers(): Response<List<UserData>> = apiService.getUsers()
    override suspend fun getPosts(): Response<List<PostData>> = apiService.getPosts()

}