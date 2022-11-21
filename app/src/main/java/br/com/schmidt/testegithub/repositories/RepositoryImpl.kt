package br.com.schmidt.testegithub.repositories

import android.util.Log
import br.com.schmidt.testegithub.retrofitInterface.RetrofitInterface
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.models.ListRepositoriesObject
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

class RepositoryImpl @Inject constructor(): Repository {

    @Inject
    lateinit var retrofitService: RetrofitInterface

    override suspend fun getAllGithubJavaRepositories(page: Int): ListRepositoriesObject? {
        try {
            val callback = retrofitService.getAllGithubJavaRepositories(page = page)
            if (callback.isSuccessful) {
                callback.body()?.let {
                    return it
                }
            } else {
                Log.d("Adriano", "Faio")
            }
        } catch (e: Exception){
            Log.d("Adriano", "Faio aqui: $e")
        }
        return null
    }

    override suspend fun getAllPullRequestsFromRepository(creator: String, repository: String, page: Int): List<ItemPullRequest>? {
        Log.d("Adriano", "Teste do creator = $creator, e repositorio = $repository")
        try {
            val callback = retrofitService.getAllPullRequestsFromRepository(creator = creator, repository = repository, page = page)
            if (callback.isSuccessful) {
                callback.body()?.let {
                    return it
                }
            } else {
                Log.d("Adriano", "Faio")
            }
        } catch (e: Exception){
            Log.d("Adriano", "Faio aqui: $e")
        }
        return null
    }
}