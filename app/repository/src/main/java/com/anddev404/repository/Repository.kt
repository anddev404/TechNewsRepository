package com.anddev404.repository

import com.anddev404.repository.remote.ApiInterface
import com.anddev404.repository.remote.ApiInterface2
import com.anddev404.repository.remote.ApiSource
import com.anddev404.repository.remote.Tech_news_Api.Tech_news_Api
import com.anddev404.repository.remote.bing_news_search_Api.BingNewsApi
import com.anddev404.repository.remote.fake_Api.FakeApi
import com.anddev404.repository.remote.fake_Api.FakeApiV2
import com.anddev404.repository.remote.image_loaders.ImageLoaderInterface
import com.anddev404.repository.remote.image_loaders.ImageLoaderSource
import com.anddev404.repository.remote.image_loaders.picasso.PicassoLibrary
import com.anddev404.repository.remote.news_api.NewsApi

class Repository {

    fun getApi(source: ApiSource): ApiInterface {

        when (source) {
            ApiSource.FAKE_API -> return FakeApi()
            ApiSource.TECH_NEWS -> return Tech_news_Api()
            ApiSource.BING_NEWS_SEARCH -> return BingNewsApi()
            ApiSource.NEWS -> return NewsApi()
        }
        return FakeApi()//todo change 'return' to exception or default api
    }

    fun getApiV2(source: ApiSource = ApiSource.FAKE_API): ApiInterface2 {

        when (source) {
            ApiSource.FAKE_API -> return FakeApiV2()
            ApiSource.NEWS -> return NewsApi()
        }
        return FakeApiV2()
    }

    fun getImageLoader(source: ImageLoaderSource): ImageLoaderInterface {

        when (source) {
            ImageLoaderSource.PICASSO_LIBRARY -> return PicassoLibrary()
            //todo add glide
        }
        return PicassoLibrary()
    }
}