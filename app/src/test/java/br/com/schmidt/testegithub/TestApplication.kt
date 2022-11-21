package br.com.schmidt.testegithub

import br.com.schmidt.testegithub.di.AppComponent
import br.com.schmidt.testegithub.di.AppModule
import br.com.schmidt.testegithub.di.DaggerAppComponent

class TestApplication: MyApplication() {

    private lateinit var appComponent: TestComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerTestComponent.builder().appTestModule(AppTestModule()).build()
    }

    override fun getAppComponent(): AppComponent {
        return appComponent
    }
}