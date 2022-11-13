package br.com.schmidt.testegithub.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.repositories.Repository
import kotlinx.coroutines.async
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RepositoriesViewModel : ViewModel() {

    private val repositoriesMutableLiveData = MutableLiveData<List<ItemRepository>>()

    val repositoriesLiveData: LiveData<List<ItemRepository>> get() = repositoriesMutableLiveData

    val teste = arrayListOf("Ola1", "Ola2", "Ola3","Ola4", "Ola5", "Ola6", "Ola7", "Ola8", "Ola9", "Ola10", "Ola11")

    fun getRepositories(){
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        viewModelScope.async {
            try {
                val callback = retrofit.create(Repository::class.java)
                var apiInterface = callback.getAllGithubJavaRepositories()
                if (apiInterface.isSuccessful) {
                    Log.d(
                        "Adriano", "Teste do objeto: " +
                                "${apiInterface.body()!![0].description} " +
                                "${apiInterface.body()!![0].name} " +
                                "${apiInterface.body()!![0].full_name} " +
                                "${apiInterface.body()!![0].stargazers_count} " +
                                "${apiInterface.body()!![0].owner.avatar_url} "
                    )
                    apiInterface.body()?.let { list ->
                        repositoriesMutableLiveData.postValue(list)
                    }
                } else {
                    Log.d("Adriano", "Faio")
                }
            } catch (e: Exception){
                Log.d("Adriano", "Faio aqui: $e")
            }
        }
    }
}