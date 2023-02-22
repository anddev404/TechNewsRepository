package com.anddev404.repository.errors

interface Error {
    fun code(): Int
    fun message(): String
}