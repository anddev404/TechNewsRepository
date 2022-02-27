package com.anddev404.repository.remote.Tech_news_Api


data class Response_Tech_news(
    var title: String = "",
    val para: String = "",
    val img: String = "",
    val dateTime: String = "",
    val link: String = ""
) {

    companion object {
        const val apiKeyValue = "a8c8f09426mshbe1aa1787990dd7p12d76ejsn484423dcef66"
        const val apiKeyName = "x-rapidapi-key"

        const val xRapidapiHostValue = "tech-news3.p.rapidapi.com"
        const val xRapidapiHostName = "x-rapidapi-host"
    }
}
