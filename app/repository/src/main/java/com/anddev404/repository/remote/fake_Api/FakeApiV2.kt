package com.anddev404.repository.remote.fake_Api

import androidx.lifecycle.MutableLiveData
import com.anddev404.repository.errors.ResponseError
import com.anddev404.repository.model.News
import com.anddev404.repository.model.Response
import com.anddev404.repository.model.SingularNews
import com.anddev404.repository.remote.ApiInterface2
import kotlinx.coroutines.delay
import kotlin.random.Random

class FakeApiV2 : ApiInterface2 {

    override suspend fun getResponse(
        source: String,
        page: Int,
        pageSize: Int,
        language: String
    ): Response {

        delay(Random.nextLong(3000))
        val randomResponse = Random.nextInt(10)
        val response = arrayListOf(
            SingularNews(
                "example header 1",
                "www.google.com",
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
            ),
            SingularNews(
                "example header 2",
                "www.google.com",
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
            ),
            SingularNews(
                "example header 3",
                "www.google.com",
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
            ),
            SingularNews(
                "example header 4",
                "www.google.com",
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
            ),
        )
        val error = ResponseError.BAD_RESPONSE_CODE

        if (randomResponse % 2 == 0) return Response(
            411,
            MutableLiveData(),
            MutableLiveData(error)
        )
        return Response(200, MutableLiveData(response), MutableLiveData())

    }

    override suspend fun getNewsOrEmptyList(source: String): News {
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