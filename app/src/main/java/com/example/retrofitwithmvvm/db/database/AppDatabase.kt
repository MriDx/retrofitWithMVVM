package com.example.retrofitwithmvvm.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitwithmvvm.db.dao.AppDatabaseDao
import com.example.retrofitwithmvvm.db.table.Address
import com.example.retrofitwithmvvm.db.table.Company
import com.example.retrofitwithmvvm.db.table.Geo
import com.example.retrofitwithmvvm.db.table.User

@Database(
    entities = [User::class, Geo::class, Address::class, Company::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val dbName = "app_db*"

    }

    abstract fun appDatabaseDao(): AppDatabaseDao

}