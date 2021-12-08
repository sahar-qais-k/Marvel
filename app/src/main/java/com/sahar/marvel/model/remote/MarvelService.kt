package com.sahar.marvel.model.remote

import com.sahar.marvel.model.remote.response.characters.Characters
import com.sahar.marvel.model.remote.response.characters.Result
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    suspend fun getCharacters() : Response<Characters<Result>>
}