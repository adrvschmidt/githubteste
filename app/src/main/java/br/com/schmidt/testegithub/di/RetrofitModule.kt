package br.com.schmidt.testegithub.di

import br.com.schmidt.testegithub.repositories.Repository
import br.com.schmidt.testegithub.repositories.RepositoryImpl
import br.com.schmidt.testegithub.utils.Constants.Companion.BASE_URL
import br.com.schmidt.testegithub.retrofitInterface.RetrofitInterface
import br.com.schmidt.testegithub.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

/*    @Singleton
    @Provides
    fun getRetrofitInterface(retrofit: Retrofit): RetrofitInterface {
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }*/

    @Singleton
    @Provides
    fun getRetrofitInterface(retrofit: Retrofit): RetrofitInterface {
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Module
    interface AppModule2{
        @Binds
        abstract fun repository(repositoryImpl: RepositoryImpl): Repository
    }
}