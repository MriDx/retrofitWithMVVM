package com.example.retrofitwithmvvm.db.dao

import androidx.room.*
import com.example.retrofitwithmvvm.db.relation.User_
import com.example.retrofitwithmvvm.db.table.Address
import com.example.retrofitwithmvvm.db.table.Company
import com.example.retrofitwithmvvm.db.table.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Dao
interface AppDatabaseDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM ${User.TABLE_NAME} ORDER BY id desc LIMIT 1")
    suspend fun getUser(): User

    @Query("DELETE FROM ${User.TABLE_NAME}")
    suspend fun deleteUser()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(address: Address): Long

    @Query("SELECT * FROM ${Address.TABLE_NAME} ORDER BY id desc LIMIT 1")
    suspend fun getAddress(): Address

    @Query("DELETE FROM ${Address.TABLE_NAME}")
    suspend fun deleteAddress()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompany(company: Company): Long

    @Query("SELECT * FROM ${Company.TABLE_NAME} ORDER BY id desc LIMIT 1")
    suspend fun getCompany(): Company

    @Query("DELETE FROM ${Company.TABLE_NAME}")
    suspend fun deleteCompany()

    @Transaction()
    suspend fun saveUser(user: User_): Long {
        return withContext(Dispatchers.IO) {
            val userId = insertUser(user.user)
            val addressId = insertAddress(address = user.address)
            val companyId = insertCompany(company = user.company)
            userId
        }
    }

    @Transaction()
    suspend fun deleteUserData() {
        withContext(Dispatchers.IO) {
            deleteUser()
            deleteAddress()
            deleteCompany()
        }
    }

}