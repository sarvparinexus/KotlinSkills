package kotlins.skills.remember

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlins.skills.remember.di.*
import javax.inject.Inject

//import org.koin.android.ext.koin.androidContext
//import org.koin.android.ext.koin.androidLogger
//import org.koin.core.context.startKoin
//import org.koin.core.logger.Level

class MainApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object {

        lateinit var instance: MainApp
            private set
    }

    override fun onCreate() {
        super.onCreate()

        //start dagger
        DaggerKotlinSkillsComponent.builder()
            .applicationContext(applicationContext)
            .build().inject(this)


//        startKoin {
//            androidLogger(Level.NONE)
//            androidContext(this@MainApp)
//            modules(
//                listOf(
//                    apiModule,
//                    repositoryModule,
//                    viewModelModule,
//                    retrofitModule
//                )
//            )
//
//        }
        instance = this
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


    override fun androidInjector() = dispatchingAndroidInjector
}