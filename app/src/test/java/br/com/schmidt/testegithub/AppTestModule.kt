package br.com.schmidt.testegithub

import br.com.schmidt.testegithub.ui.repositories.Repository
import br.com.schmidt.testegithub.ui.repositories.RepositoryImpl
import br.com.schmidt.testegithub.retrofitInterface.RetrofitInterface
import br.com.schmidt.testegithub.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppTestModule {
    @Provides
    fun repository(): Repository {
        return FakeRepositoryImpl()
    }

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
}