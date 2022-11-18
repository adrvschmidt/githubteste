package br.com.schmidt.testegithub

import android.app.Application
import br.com.schmidt.testegithub.di.AppComponent
import br.com.schmidt.testegithub.di.AppModule
import br.com.schmidt.testegithub.di.DaggerAppComponent

open class MyApplication: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}