package com.example.a20230715_joshgebbeken_nycschools.startup

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber

class AppStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Timber.v("[create]")
        // no-op
    }

    override fun dependencies(): List<Class<out Initializer<out Any>>> = listOf(
        TimberStartupInitializer::class.java,
        KoinStartupInitializer::class.java,
    )
}