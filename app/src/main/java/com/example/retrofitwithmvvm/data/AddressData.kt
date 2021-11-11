package com.example.retrofitwithmvvm.data

import com.google.gson.annotations.SerializedName

data class AddressData(
    @SerializedName("street") var street: String,
    @SerializedName("suite") var suite: String,
    @SerializedName("city") var city: String,
    @SerializedName("zipcode") var zipcode: String,
    @SerializedName("geo") var geoData: GeoData
)

data class GeoData(
    @SerializedName("lat") var latitude: String,
    @SerializedName("lng") var longitude: String
)


/*
{
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
    "lat": "-37.3159",
    "lng": "81.1496"
}
},
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
}
}*/
