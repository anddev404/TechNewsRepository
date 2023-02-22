package com.anddev404.repository.remote.news_api

data class NewsResponse(val articles: ArrayList<News> = arrayListOf()) {

    data class News(
        val title: String = "",
        val url: String = "",
        val description: String = "",
        val urlToImage: String = "",
        val publishedAt: String = ""
    )
}