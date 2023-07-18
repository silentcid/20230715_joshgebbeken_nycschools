package com.example.a20230715_joshgebbeken_nycschools.data.utils

import com.example.a20230715_joshgebbeken_nycschools.domain.models.ApiException
import retrofit2.HttpException

fun HttpException.toApiException() = ApiException(code(), message(), response()?.errorBody().toString())