package com.anddev404.repository.remote

import com.anddev404.repository.model.News
import com.anddev404.repository.model.SingularNews
import kotlinx.coroutines.delay

class FakeApi : ApiInterface {

    override suspend fun getNews(): News {
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