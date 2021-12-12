package com.sahar.marvel.data.remote

import com.sahar.marvel.BuildConfig
import com.sahar.marvel.data.remote.response.characters.BaseResponse
import com.sahar.marvel.data.remote.response.characters.CharacterDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarvelService {
    @GET("characters")
    suspend fun getCharacters() : Response<BaseResponse<CharacterDto>>
}