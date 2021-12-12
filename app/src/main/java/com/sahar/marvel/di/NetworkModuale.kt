package com.sahar.marvel.di

import com.sahar.marvel.BuildConfig
import com.sahar.marvel.data.remote.AuthInterceptor
import com.sahar.marvel.data.remote.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuale {

    @Singleton
    @Provides
    fun provideMarvelService(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): MarvelService{
         val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

        return retrofit.create(MarvelService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(authInterceptor: AuthInterceptor,httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
         return OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(): AuthInterceptor = AuthInterceptor()

    @Singleton
    @Provides
    fun provideLoginingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()
}
