package com.anddev404.repository.remote.Tech_news_Api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Tech_news_Retrofit_Service {

    @Headers(
        "${Response_Tech_news.apiKeyName}: ${Response_Tech_news.apiKeyValue}",
        "${Response_Tech_news.xRapidapiHostName}: ${Response_Tech_news.xRapidapiHostValue}"
    )
    @GET(
        "{source}"
    )
    suspend fun getNews(//tu suspend
        @Path("source") source: String
    ): Response<ArrayList<Response_Tech_news>>
}