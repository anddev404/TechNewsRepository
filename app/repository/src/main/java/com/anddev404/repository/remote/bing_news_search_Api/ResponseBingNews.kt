package com.anddev404.repository.remote.bing_news_search_Api

data class ResponseBingNews(val value: ArrayList<News> = arrayListOf()) {

    data class News(
        val name: String = "",
        val url: String = "",
        val description: String = "",
        val image: Image = Image(),
        val datePublished: String = ""
    )

    data class Image(val thumbnail: Thumbnail = Thumbnail())
    data class Thumbnail(val contentUrl: String = "")

}