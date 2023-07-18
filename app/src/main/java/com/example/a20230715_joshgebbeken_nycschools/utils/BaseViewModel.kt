package com.example.a20230715_joshgebbeken_nycschools.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230715_joshgebbeken_nycschools.R
import com.example.a20230715_joshgebbeken_nycschools.domain.infrastructure.DispatcherProvider
import com.example.a20230715_joshgebbeken_nycschools.domain.models.ApiException
import com.example.a20230715_joshgebbeken_nycschools.domain.models.UserFacingError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber
import java.io.IOException

abstract class BaseViewModel: ViewModel(), KoinComponent {

    protected val dispatcherProvider: DispatcherProvider by inject()
    val errorStateFlow: MutableStateFlow<UserFacingError> = MutableStateFlow(UserFacingError.NoError)

    fun <T> Result<T>.handleFailure(): Result<T> {
        exceptionOrNull()?.let { throwable ->
            when (throwable) {
                is ApiException -> {
                    errorStateFlow.value = UserFacingError.ApiError(code = throwable.code, title = R.string.api_error_title, description = R.string.api_error_description)
                }
                else -> {
                    errorStateFlow.value = UserFacingError.GeneralError(R.string.general_error_title, description = R.string.general_error_description)
                }
            }
        }
        return this
    }

    fun <T> Result<T>.logFailure(): Result<T> {
        exceptionOrNull()?.let { throwable ->
            when (throwable) {
                is ApiException -> {
                    Timber.d("${throwable.code}  ${throwable.responseBody}")
                }
                is IOException -> {
                    Timber.d("${throwable.message}")
                }
                else -> {
                    Timber.d("${throwable.message}")
                }
            }
        }
        return this
    }
}