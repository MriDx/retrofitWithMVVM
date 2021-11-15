package com.example.retrofitwithmvvm.db.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.retrofitwithmvvm.db.table.Address
import com.example.retrofitwithmvvm.db.table.Company
import com.example.retrofitwithmvvm.db.table.User

data class User_(
    @Embedded
    var user: User,
    @Relation(parentColumn = "id", entityColumn = "user_id")
    var address: Address,
    @Relation(parentColumn = "id", entityColumn = "user_id")
    var company: Company
)