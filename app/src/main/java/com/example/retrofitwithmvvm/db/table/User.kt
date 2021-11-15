package com.example.retrofitwithmvvm.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.retrofitwithmvvm.data.UserData

@Entity(tableName = "users")
class User {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "user_id")
    var userId: Int

    @ColumnInfo(name = "name")
    var name: String

    @ColumnInfo(name = "user_name")
    var userName: String

    @ColumnInfo(name = "email")
    var email: String

    @ColumnInfo(name = "phone")
    var phone: String

    @ColumnInfo(name = "website")
    var website: String


    companion object {
        const val TABLE_NAME = "users"
    }


    constructor(
        id: Int,
        userId: Int,
        name: String,
        userName: String,
        email: String,
        phone: String,
        website: String
    ) {
        this.id = id
        this.userId = userId
        this.name = name
        this.userName = userName
        this.email = email
        this.phone = phone
        this.website = website
    }

    @Ignore
    constructor(
        userId: Int,
        name: String,
        userName: String,
        email: String,
        phone: String,
        website: String
    ) {
        this.userId = userId
        this.name = name
        this.userName = userName
        this.email = email
        this.phone = phone
        this.website = website
    }


}