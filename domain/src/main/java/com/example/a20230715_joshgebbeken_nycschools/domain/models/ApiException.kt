package com.example.a20230715_joshgebbeken_nycschools.domain.models

class ApiException(
    val code: Int,
    message: String,
    val responseBody: String,
) : RuntimeException(message)
