package com.example.retrofitwithmvvm.ui.activity.posts_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithmvvm.data.PostData
import com.example.retrofitwithmvvm.network.ApiService
import com.example.retrofitwithmvvm.network.utils.Resource
import com.example.retrofitwithmvvm.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsActivityViewModel @Inject constructor(private val postsRepository: PostsRepository) :
    ViewModel() {


    private var _response = MutableLiveData<Resource<List<PostData>>>()
    val response: LiveData<Resource<List<PostData>>> get() = _response

    init {
        loadPosts()
    }

    private fun loadPosts() = viewModelScope.launch {

        _response.postValue(Resource.loading(null))

        val postsResponse = postsRepository.getPosts()

        if (postsResponse.isSuccessful) {
            _response.postValue(Resource.success(postsResponse.body()!!))
        } else {
            _response.postValue(Resource.error(postsResponse.errorBody().toString(), null))
        }

    }


}