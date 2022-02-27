package com.anddev404.repository.remote.Tech_news_Api

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Tech_news_Retrofit_Service {

    companion object {

        private val retrofit = Retrofit.Builder()
            .baseUrl(Response_Tech_news.baseUrl)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val Tech_news_ApiService = retrofit.create(Tech_news_Retrofit_Service::class.java)

    }

    @Headers(
        "${Response_Tech_news.apiKeyName}: ${Response_Tech_news.apiKeyValue}",
        "${Response_Tech_news.xRapidapiHostName}: ${Response_Tech_news.xRapidapiHostValue}"
    )
    @GET(
        "{source}"
    )
    suspend fun getNews(
        @Path("source") source: String
    ): Response<ArrayList<Response_Tech_news>>
}