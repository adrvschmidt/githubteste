package br.com.schmidt.testegithub.di

import br.com.schmidt.testegithub.PullRequestPagingSource
import br.com.schmidt.testegithub.RepositoriesPagingSource
import br.com.schmidt.testegithub.repositories.RepositoryImpl
import br.com.schmidt.testegithub.viewmodels.PullRequestViewModel
import br.com.schmidt.testegithub.viewmodels.RepositoriesViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(repositoriesViewModel: RepositoriesViewModel)

    fun inject(repositoryImpl: RepositoryImpl)

    fun inject(repositoriesPagingSource: RepositoriesPagingSource)

    fun inject(pullRequestPagingSource: PullRequestPagingSource)

    fun inject(pullRequestViewModel: PullRequestViewModel)
}