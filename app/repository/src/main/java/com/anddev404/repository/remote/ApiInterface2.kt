package com.anddev404.repository.remote

import com.anddev404.repository.model.Response

interface ApiInterface2 : ApiInterface {

    suspend fun getResponse(
        category: String = "android",
        page: Int = 1,
        pageSize: Int = 10,
        language: String="en"
    ): Response
}