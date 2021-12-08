package com.sahar.marvel.data.remote.response.characters


import com.google.gson.annotations.SerializedName

data class ItemXX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)