package com.anddev404.repository.model

class News(val news: List<SingularNews> = arrayListOf<SingularNews>()) {

    fun getString(): String {

        var stringBuilder = ""

        for (plurarNews in news) {
            stringBuilder = stringBuilder + plurarNews.header + "\n"
        }
        return stringBuilder
    }
}