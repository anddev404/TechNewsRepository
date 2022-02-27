package com.anddev404.repository.remote.Tech_news_Api


data class Response_Tech_news(
    var title: String = "",
    val para: String = "",
    val img: String = "",
    val dateTime: String = "",
    val link: String = ""
) {

    companion object {
        const val apiKey = "a8c8f09426mshbe1aa1787990dd7p12d76ejsn484423dcef66"
        const val xRapidapiHost = "tech-news3.p.rapidapi.com"
    }
}
