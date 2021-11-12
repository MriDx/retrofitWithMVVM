package com.example.retrofitwithmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.data.PostData
import com.example.retrofitwithmvvm.network.ApiHelper
import com.example.retrofitwithmvvm.network.utils.Resource
import javax.inject.Inject


class PostsRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getPosts() = apiHelper.getPosts()


}