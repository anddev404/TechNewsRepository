package com.anddev404.repository.remote.bing_news_search_Api

import com.anddev404.repository.model.News
import com.anddev404.repository.model.SingularNews
import com.anddev404.repository.remote.ApiInterface

class BingNewsApi : ApiInterface {

    private var api: BingNewsRetrofitService = BingNewsRetrofitService.BingNewsApiService

    override suspend fun getNewsOrEmptyList(source: String): News {

        try {
            val newsResponse = api.getNews("android")
            if (newsResponse.isSuccessful) {

                if (newsResponse.code() == 200) {
                    newsResponse.body()?.let {
                        return convertBingNewsResponseToNewsModel(it)
                    }
                }
            }
        } catch (t: Throwable) {
        }

        return News(arrayListOf())
    }

    private fun convertBingNewsResponseToNewsModel(response: BingNewsResponse): News {

        val news = News()

        response.value.forEach { singularNews ->
            ((news.news) as ArrayList<SingularNews>).add(
                SingularNews(
                    singularNews.name,
                    singularNews.url,
                    singularNews.image.thumbnail.contentUrl,
                    singularNews.datePublished
                )
            )
        }

        return news
    }
}