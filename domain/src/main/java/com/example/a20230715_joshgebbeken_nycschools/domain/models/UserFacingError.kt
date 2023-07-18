package com.example.a20230715_joshgebbeken_nycschools.domain.models

import androidx.annotation.StringRes

sealed class UserFacingError {
    data class GeneralError(
        @StringRes val title: Int,
        @StringRes val description: Int
    ) : UserFacingError()
    data class ApiError(
        val code: Int = 0,
        @StringRes val title: Int,
        @StringRes val description: Int
    ) : UserFacingError()
    object NoError : UserFacingError()
}