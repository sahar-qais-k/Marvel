package com.sahar.marvel.model.remote.response.characters


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)