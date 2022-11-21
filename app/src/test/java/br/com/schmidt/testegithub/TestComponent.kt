package br.com.schmidt.testegithub

import br.com.schmidt.testegithub.di.AppComponent
import br.com.schmidt.testegithub.di.AppModule
import br.com.schmidt.testegithub.ui.repositories.RepositoryImpl
import br.com.schmidt.testegithub.ui.viewmodels.PullRequestViewModel
import br.com.schmidt.testegithub.ui.viewmodels.RepositoriesViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppTestModule::class])
interface TestComponent: AppComponent {

    fun inject(exampleUnitTest: ExampleUnitTest)
    override fun inject(pullRequestViewModel: PullRequestViewModel)
    override fun inject(repositoriesViewModel: RepositoriesViewModel)

}