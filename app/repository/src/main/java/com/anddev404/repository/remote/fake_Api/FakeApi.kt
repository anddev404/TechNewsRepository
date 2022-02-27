package com.anddev404.repository.remote.fake_Api

import com.anddev404.repository.model.News
import com.anddev404.repository.model.SingularNews
import com.anddev404.repository.remote.ApiInterface
import kotlinx.coroutines.delay

class FakeApi : ApiInterface {

    override suspend fun getNews(source: String): News {
        delay(1000)
        return News(
            arrayListOf(
                SingularNews("example header 1"),
                SingularNews("example header 2"),
                SingularNews("example header 3"),
                SingularNews("example header 4")
            )
        )
    }
}