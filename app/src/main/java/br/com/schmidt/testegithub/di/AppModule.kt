package br.com.schmidt.testegithub.di

import br.com.schmidt.testegithub.ui.repositories.Repository
import br.com.schmidt.testegithub.ui.repositories.RepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
interface AppModule {

    @Singleton
    @Binds
    fun repository(repositoryImpl: RepositoryImpl): Repository
}