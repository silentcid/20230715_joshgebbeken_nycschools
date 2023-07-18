package com.example.a20230715_joshgebbeken_nycschools.startup

import android.content.Context
import androidx.startup.Initializer
import com.example.a20230715_joshgebbeken_nycschools.data.di.DataModule
import com.example.a20230715_joshgebbeken_nycschools.data.di.NetworkModule
import com.example.a20230715_joshgebbeken_nycschools.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import timber.log.Timber

class KoinStartupInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        Timber.v("[create]")
        // Can't use Koin to create this due to necessary logic needed in startKoin for androidLogger. Just create/use an instance here for this special case.
        //val buildConfigProvider = BuildConfigProviderImpl()
        return startKoin {
            androidContext(context)

            // Turn definition override off (it is on by default) so Koin throws a `DefinitionOverrideException` when a definition is provided in multiple locations of the graph.
            // See https://insert-koin.io/docs/reference/koin-core/modules/#overriding-definition-or-module-310
            allowOverride(override = false)
            modules(
                listOf(
                    AppModule.module,
                    DataModule.module,
                    NetworkModule.module,
                )
            )
        }
    }

    override fun dependencies(): List<Class<TimberStartupInitializer>> = listOf(TimberStartupInitializer::class.java)
}