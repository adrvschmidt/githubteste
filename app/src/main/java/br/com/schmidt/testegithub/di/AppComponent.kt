package br.com.schmidt.testegithub.di

import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.ui.fragments.ShowPullRequestsFragment
import br.com.schmidt.testegithub.ui.fragments.ShowRepositoriesFragment
import br.com.schmidt.testegithub.ui.pagings.PullRequestPagingSource
import br.com.schmidt.testegithub.ui.pagings.RepositoriesPagingSource
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ViewModule::class])
interface AppComponent {

    fun inject(myApplication: MyApplication)

    fun inject(showRepositoriesFragment: ShowRepositoriesFragment)

    fun inject(pullRequestsFragment: ShowPullRequestsFragment)
}