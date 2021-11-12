package com.example.retrofitwithmvvm.repository

import com.example.retrofitwithmvvm.network.ApiHelper
import javax.inject.Inject

class UserListRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}