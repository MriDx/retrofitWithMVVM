package com.example.retrofitwithmvvm.data

import com.example.retrofitwithmvvm.db.relation.User_
import com.example.retrofitwithmvvm.db.table.Address
import com.example.retrofitwithmvvm.db.table.Company
import com.example.retrofitwithmvvm.db.table.User
import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("username") var username: String,
    @SerializedName("email") var email: String,
    @SerializedName("address") var address: AddressData,
    @SerializedName("phone") var phone: String,
    @SerializedName("website") var website: String,
    @SerializedName("company") var company: CompanyData
) {

    fun toRoomDbTable(): User_ {
        val user = User(
            userId = id,
            name = name,
            userName = username,
            email = email,
            phone = phone,
            website = website
        )
        val address_ = Address(
            userId = id,
            street = address.street,
            suite = address.suite,
            city = address.city,
            zipcode = address.zipcode
        )
        val company_ = Company(
            userId = id,
            name = company.name,
            catchPhrase = company.catchPhrase,
            bs = company.bs
        )
        return User_(
            user = user,
            address = address_,
            company = company_
        )
    }

}
