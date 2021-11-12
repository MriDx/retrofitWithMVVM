package com.example.retrofitwithmvvm.ui.activity.user_list_activity

import android.util.Log
import androidx.lifecycle.*
import com.example.retrofitwithmvvm.data.UserData
import com.example.retrofitwithmvvm.network.utils.Resource
import com.example.retrofitwithmvvm.repository.UserListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class UserListActivityViewModel @Inject constructor(
    private val userListRepository: UserListRepository
) : ViewModel() {

    private var _response = MutableLiveData<Resource<List<UserData>>>()
    val response: LiveData<Resource<List<UserData>>> get() = _response

    init {
        getUserList()
    }

    private fun getUserList() = viewModelScope.launch {
        _response.postValue(Resource.loading(null))
        val userListResponse = userListRepository.getUsers()
        if (userListResponse.isSuccessful) {
            _response.postValue(Resource.success(userListResponse.body()))
        } else {
            _response.postValue(Resource.error(userListResponse.errorBody().toString(), null))
        }
    }


}