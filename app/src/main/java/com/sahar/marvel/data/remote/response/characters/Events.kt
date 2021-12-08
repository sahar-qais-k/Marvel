package com.sahar.marvel.data.remote.response.characters


import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<ItemX>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)