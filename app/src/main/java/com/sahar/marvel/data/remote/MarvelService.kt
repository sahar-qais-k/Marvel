package com.sahar.marvel.data.remote

import com.sahar.marvel.data.remote.response.characters.BaseResponse
import com.sahar.marvel.data.remote.response.characters.CharacterDto
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    suspend fun getCharacters() : Response<BaseResponse<CharacterDto>>
}