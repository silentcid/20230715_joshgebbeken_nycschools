package com.example.a20230715_joshgebbeken_nycschools.data.di

import com.example.a20230715_joshgebbeken_nycschools.data.implementations.SchoolRepositoryImplementation
import com.example.a20230715_joshgebbeken_nycschools.data.infrastructure.DispatcherProviderImplementation
import com.example.a20230715_joshgebbeken_nycschools.data.network.SchoolServiceFactory
import com.example.a20230715_joshgebbeken_nycschools.data.repositories.SchoolRepository
import com.example.a20230715_joshgebbeken_nycschools.data.serialization.ProtectedPropertyAdapter
import com.example.a20230715_joshgebbeken_nycschools.data.utils.SchoolDtoItemJsonAdapter
import com.example.a20230715_joshgebbeken_nycschools.data.utils.SchoolSatDtoJsonAdapter
import com.example.a20230715_joshgebbeken_nycschools.domain.infrastructure.DispatcherProvider
import com.squareup.moshi.Moshi
import org.koin.dsl.module
import java.time.Clock

object DataModule {
    val module = module {
        single<Clock> { Clock.systemDefaultZone() }
        single<Moshi> { Moshi.Builder()
            .add(ProtectedPropertyAdapter())
            .add(SchoolDtoItemJsonAdapter())
            .add(SchoolSatDtoJsonAdapter())
            .build()
        }
        single<SchoolRepository> { SchoolRepositoryImplementation() }
        single<DispatcherProvider> { DispatcherProviderImplementation() }
    }
}

object NetworkModule {
    val module = module {
        single { SchoolServiceFactory().produce() }
    }
}