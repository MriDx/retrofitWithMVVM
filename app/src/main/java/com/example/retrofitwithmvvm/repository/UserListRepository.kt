package com.example.retrofitwithmvvm.repository

import android.content.res.Resources
import com.example.retrofitwithmvvm.data.UserData
import com.example.retrofitwithmvvm.db.database.AppDatabase
import com.example.retrofitwithmvvm.network.ApiHelper
import com.example.retrofitwithmvvm.network.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserListRepository
@Inject
constructor(
    private val apiHelper: ApiHelper,
    private val appDatabase: AppDatabase
) {

    suspend fun getUsers() = apiHelper.getUsers()

    suspend fun getAndSaveUsers() = withContext(Dispatchers.IO) {
        val users = apiHelper.getUsers()
        if (users.isSuccessful) {
            saveUsers(users.body()!!)
            Resource.success(users.body()!!)
        } else {
            Resource.error(users.errorBody().toString(), null)
        }

    }

    private suspend fun saveUsers(users: List<UserData>) {
        withContext(Dispatchers.IO) {
            users.map {
                appDatabase.appDatabaseDao().saveUser(it.toRoomDbTable())
            }
        }
    }

}