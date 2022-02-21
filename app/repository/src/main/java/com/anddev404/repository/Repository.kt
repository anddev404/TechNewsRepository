package com.anddev404.repository

import com.anddev404.repository.remote.ApiSource
import com.anddev404.repository.remote.FakeApi
import com.anddev404.repository.remote.ApiInterface

class Repository {

    fun getApi(source: ApiSource): ApiInterface {

        when (source) {
            ApiSource.FAKE_API -> FakeApi()

        }
        return FakeApi()//todo change 'return' to exception or default api
    }
}