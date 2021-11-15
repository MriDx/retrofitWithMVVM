package com.example.retrofitwithmvvm.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geo")
data class Geo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "address_id")
    var addressId: Int,
    @ColumnInfo(name = "latitude")
    var latitude: String,
    @ColumnInfo(name = "longitude")
    var longitude: String
)
