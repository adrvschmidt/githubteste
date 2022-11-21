package br.com.schmidt.testegithub.di

import br.com.schmidt.testegithub.ui.pagings.PullRequestPagingSource
import br.com.schmidt.testegithub.ui.pagings.RepositoriesPagingSource
import br.com.schmidt.testegithub.ui.repositories.Repository
import br.com.schmidt.testegithub.ui.viewmodels.PullRequestViewModel
import br.com.schmidt.testegithub.ui.viewmodels.RepositoriesViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModule {

    @Singleton
    @Provides
    fun pagePullRequest(repository: Repository): PullRequestPagingSource {
        return PullRequestPagingSource(repository)
    }

    @Singleton
    @Provides
    fun viewModelPullRequest(repository: Repository): PullRequestViewModel {
        return PullRequestViewModel(pagePullRequest(repository))
    }

    @Singleton
    @Provides
    fun pageRepository(repository: Repository): RepositoriesPagingSource {
        return RepositoriesPagingSource(repository)
    }

    @Singleton
    @Provides
    fun viewModelRepository(repository: Repository): RepositoriesViewModel {
        return RepositoriesViewModel(pageRepository(repository))
    }
}