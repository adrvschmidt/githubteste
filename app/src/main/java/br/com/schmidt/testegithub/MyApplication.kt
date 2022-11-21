package br.com.schmidt.testegithub

import android.app.Application
import br.com.schmidt.testegithub.di.AppComponent
import br.com.schmidt.testegithub.di.DaggerAppComponent
import br.com.schmidt.testegithub.di.RetrofitModule

open class MyApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().retrofitModule(RetrofitModule()).build()
        appComponent.inject(this)
    }

    open fun getAppComponent(): AppComponent {
        return appComponent
    }
}