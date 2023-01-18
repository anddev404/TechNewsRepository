package com.anddev404.repository.remote.Tech_news_Api

import com.anddev404.repository.model.News
import com.anddev404.repository.model.SingularNews
import com.anddev404.repository.remote.ApiInterface

class Tech_news_Api : ApiInterface {

    var api: Tech_news_Retrofit_Service

    init {
        api = Tech_news_Retrofit_Service.Tech_news_ApiService
    }

    override suspend fun getNewsOrEmptyList(source: String): News {

        try {
            var newsResponse = api.getNews("gsmarena")///TODO temporary source is 'gsmarena'
            if (newsResponse.isSuccessful) {
                if (newsResponse.code() == 200) {

                    var newsList = newsResponse.body() ?: arrayListOf()

                    return convertTechNewsResponseToNewsModel(newsList)
                }
            } else {
                //TODO error codes
            }

        } catch (t: Throwable) {//TODO catch UnknownHostException
        }

        return News(arrayListOf())
    }

    private fun convertTechNewsResponseToNewsModel(responseTechNews: List<Response_Tech_news>): News {

        var news = News()

        for (singularNews in responseTechNews) {
            ((news.news) as ArrayList<SingularNews>).add(
                SingularNews(
                    singularNews.title,
                    singularNews.link,
                    singularNews.img,
                    singularNews.dateTime
                )
            )
        }

        return news
    }
}