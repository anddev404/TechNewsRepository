package com.anddev404.repository.model

class News(var news: List<SingularNews>) {

    fun getString(): String {

        var stringBuilder = ""

        for (plurarNews in news) {
            stringBuilder = stringBuilder + plurarNews.header + "\n"
        }
        return stringBuilder
    }
}