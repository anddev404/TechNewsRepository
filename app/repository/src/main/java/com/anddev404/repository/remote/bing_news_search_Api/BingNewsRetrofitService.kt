package com.anddev404.repository.remote.bing_news_search_Api

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BingNewsRetrofitService {

    @Headers(
        "${apiKeyName}: ${apiKeyValue}",
        "${xRapidApiHostName}: ${xRapidApiHostValue}",
        "${xBingApisSDKName}: ${xBingApisSDKValue}"
    )
    @GET("news/search/")
    suspend fun getNews(
        @Query("q") tag: String,
        @Query("mkt") mkt: String,
        @Query("setLang") lang: String,
        @Query("count") count: String
    ): Response<BingNewsResponse>

    companion object {

        const val baseUrl = "https://bing-news-search1.p.rapidapi.com/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val BingNewsApiService = retrofit.create(BingNewsRetrofitService::class.java)

        //region headers
        const val apiKeyName = "X-RapidAPI-Key"
        const val apiKeyValue = "a8c8f09426mshbe1aa1787990dd7p12d76ejsn484423dcef66"

        const val xRapidApiHostName = "X-RapidAPI-Host"
        const val xRapidApiHostValue = "bing-news-search1.p.rapidapi.com"

        const val xBingApisSDKName = "X-BingApis-SDK"
        const val xBingApisSDKValue = "true"
        //endregion

    }
}