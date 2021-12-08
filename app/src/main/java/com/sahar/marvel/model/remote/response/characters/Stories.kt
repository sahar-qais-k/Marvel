package com.sahar.marvel.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<ItemXXX>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)