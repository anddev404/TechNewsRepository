package com.anddev404.repository.remote.news_api

import androidx.lifecycle.MutableLiveData
import com.anddev404.repository.errors.ResponseError
import com.anddev404.repository.model.News
import com.anddev404.repository.model.Response
import com.anddev404.repository.model.SingularNews
import com.anddev404.repository.remote.ApiInterface2

class NewsApi : ApiInterface2 {

    private var api: NewsRetrofitService = NewsRetrofitService.newsApiService

    override suspend fun getResponse(
        category: String,
        page: Int,
        pageSize: Int,
        language: String
    ): Response {

        try {
            val newsResponse = api.getNews("android", NewsRetrofitService.apiKeyValue)
            if (newsResponse.isSuccessful) {

                newsResponse.body()?.let {
                    try {
                        val news = convertNewsResponseToNewsModel(it)
                        if (news.news.isEmpty()) return Response(
                            0, MutableLiveData(), MutableLiveData(ResponseError.EMPTY_RESPONSE_BODY)
                        )
                        return Response(
                            200, MutableLiveData(ArrayList(news.news)), MutableLiveData()
                        )
                    } catch (t: Throwable) {
                        return Response(
                            0,
                            MutableLiveData(),
                            MutableLiveData(ResponseError.JSON_CONVERSION_ERROR)
                        )
                    }

                }
                return Response(
                    0, MutableLiveData(), MutableLiveData(ResponseError.EMPTY_RESPONSE_BODY)
                )
            } else {
                return Response(
                    newsResponse.code(),
                    MutableLiveData(),
                    MutableLiveData(ResponseError.BAD_RESPONSE_CODE)
                )
            }
        } catch (t: Throwable) {
            return Response(
                0, MutableLiveData(), MutableLiveData(ResponseError.UNKNOWN_HOST_EXCEPTION)
            )
        }
    }

    override suspend fun getNewsOrEmptyList(source: String): News {

        try {
            val newsResponse = api.getNews("android", NewsRetrofitService.apiKeyValue)
            if (newsResponse.isSuccessful) {

                if (newsResponse.code() == 200) {
                    newsResponse.body()?.let {

                        return convertNewsResponseToNewsModel(it)
                    }
                }
            }
        } catch (t: Throwable) {
        }

        return News()
    }

    private fun convertNewsResponseToNewsModel(response: NewsResponse): News {

        val news = News()

        response.articles?.forEach { singularNews ->
            ((news.news) as ArrayList<SingularNews>).add(
                SingularNews(
                    singularNews.title ?: "",
                    singularNews.url ?: "",
                    singularNews.urlToImage ?: "",
                    singularNews.publishedAt ?: "",
                    descriptions = singularNews.description ?: ""
                )
            )
        }
        return news
    }
}