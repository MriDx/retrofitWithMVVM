package com.example.retrofitwithmvvm.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.retrofitwithmvvm.db.table.Address.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class Address {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "user_id")
    var userId: Int

    @ColumnInfo(name = "street")
    var street: String

    @ColumnInfo(name = "suite")
    var suite: String

    @ColumnInfo(name = "city")
    var city: String

    @ColumnInfo(name = "zipcode")
    var zipcode: String

    companion object {
        const val TABLE_NAME = "addresses"
    }

    constructor(
        id: Int,
        userId: Int,
        street: String,
        suite: String,
        city: String,
        zipcode: String
    ) {
        this.id = id
        this.userId = userId
        this.street = street
        this.suite = suite
        this.city = city
        this.zipcode = zipcode
    }

    @Ignore
    constructor(userId: Int, street: String, suite: String, city: String, zipcode: String) {
        this.userId = userId
        this.street = street
        this.suite = suite
        this.city = city
        this.zipcode = zipcode
    }


}