package com.anddev404.repository

import com.anddev404.repository.model.News
import com.anddev404.repository.remote.ApiSource
import com.anddev404.repository.remote.fake_Api.FakeApi
import com.anddev404.repository.remote.ApiInterface
import com.anddev404.repository.remote.Tech_news_Api.Tech_news_Api
import com.anddev404.repository.remote.Tech_news_Api.Tech_news_Retrofit_Service

class Repository {

    fun getApi(source: ApiSource): ApiInterface {

        when (source) {
            ApiSource.FAKE_API -> return FakeApi()
            ApiSource.TECH_NEWS -> return Tech_news_Api()

        }
        return FakeApi()//todo change 'return' to exception or default api
    }
}