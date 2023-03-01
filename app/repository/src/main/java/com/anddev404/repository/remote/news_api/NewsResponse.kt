package com.anddev404.repository.remote.news_api

class NewsResponse(val articles: ArrayList<News>? = arrayListOf()) {
    class News(
        val title: String?,
        val url: String?,
        val description: String?,
        val urlToImage: String?,
        val publishedAt: String?
    )
}