package com.example.retrofitwithmvvm.network

import com.example.retrofitwithmvvm.data.UserData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    /**
     * extend ApiHelper to get apiService injected
     */

    override suspend fun getUsers(): Response<List<UserData>> = apiService.getUsers()

}