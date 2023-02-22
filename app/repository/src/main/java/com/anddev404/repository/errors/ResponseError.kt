package com.anddev404.repository.errors

enum class ResponseError(private val code: Int, private val message: String) : Error {

    DEFAULT_ERROR(1, "Unknown error"),
    NO_INTERNET_CONNECTION(2, "Turn internet connection on"),
    UNKNOWN_HOST_EXCEPTION(3, "Unknown host"),
    BAD_RESPONSE_CODE(4, "Bad response"),
    EMPTY_RESPONSE_BODY(5, "Empty response"),
    JSON_CONVERSION_ERROR(6, "Could not convert response");
    
    override fun code(): Int {
        return this.code
    }

    override fun message(): String {
        return this.message
    }
}