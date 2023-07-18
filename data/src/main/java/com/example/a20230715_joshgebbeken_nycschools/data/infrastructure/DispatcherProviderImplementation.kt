package com.example.a20230715_joshgebbeken_nycschools.data.infrastructure

import com.example.a20230715_joshgebbeken_nycschools.domain.infrastructure.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DispatcherProviderImplementation : DispatcherProvider {
    override val Default: CoroutineDispatcher = Dispatchers.Default
    override val IO: CoroutineDispatcher = Dispatchers.IO
    override val Main: CoroutineDispatcher = Dispatchers.Main
    override val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}