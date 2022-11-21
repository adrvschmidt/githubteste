package br.com.schmidt.testegithub.di

import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.PullRequestPagingSource
import br.com.schmidt.testegithub.RepositoriesPagingSource
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {

    fun inject(repositoriesPagingSource: RepositoriesPagingSource)

    fun inject(pullRequestPagingSource: PullRequestPagingSource)

    fun inject(myApplication: MyApplication)
}