package com.example.retrofitwithmvvm.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.retrofitwithmvvm.db.table.Company.Companion.TABLE_NAME
import dagger.multibindings.IntoMap

@Entity(tableName = TABLE_NAME)
class Company {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "user_id")
    var userId: Int

    @ColumnInfo(name = "name")
    var name: String

    @ColumnInfo(name = "catchPhrase")
    var catchPhrase: String

    @ColumnInfo(name = "bs")
    var bs: String

    companion object {
        const val TABLE_NAME = "companies"
    }

    constructor(id: Int, userId: Int, name: String, catchPhrase: String, bs: String) {
        this.id = id
        this.userId = userId
        this.name = name
        this.catchPhrase = catchPhrase
        this.bs = bs
    }

    @Ignore
    constructor(userId: Int, name: String, catchPhrase: String, bs: String) {
        this.userId = userId
        this.name = name
        this.catchPhrase = catchPhrase
        this.bs = bs
    }


}
