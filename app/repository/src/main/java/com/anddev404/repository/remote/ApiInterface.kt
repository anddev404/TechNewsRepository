package com.anddev404.repository.remote

import com.anddev404.repository.model.News

interface ApiInterface {

    suspend fun getNews(): News

}