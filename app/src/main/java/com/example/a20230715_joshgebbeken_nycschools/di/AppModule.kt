package com.example.a20230715_joshgebbeken_nycschools.di

import com.example.a20230715_joshgebbeken_nycschools.ui.SchoolsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val module = module {
        //single<BuildConfigProvider> { BuildConfigProviderImpl() }
        viewModel { SchoolsViewModel() }
    }
}