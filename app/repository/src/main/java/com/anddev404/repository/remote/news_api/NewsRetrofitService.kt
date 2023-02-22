package com.anddev404.repository.remote.news_api

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRetrofitService {

    @GET("everything/")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

    companion object {

        private const val baseUrl = "https://newsapi.org/v2/"//TODO add to BuildConfig

        private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsApiService: NewsRetrofitService = retrofit.create(NewsRetrofitService::class.java)

        const val apiKeyValue = "da8820a44f174fc7bbddf03e18ad6671"//TODO add to BuildConfig
    }
}