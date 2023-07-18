package com.example.a20230715_joshgebbeken_nycschools.startup

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber
import timber.log.Timber.Forest.plant


class TimberStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {

        plant(Timber.DebugTree())
        Timber.v("[create]")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}