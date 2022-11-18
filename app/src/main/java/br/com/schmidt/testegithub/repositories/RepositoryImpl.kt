package br.com.schmidt.testegithub.repositories

import android.util.Log
import br.com.schmidt.testegithub.retrofitInterface.RetrofitInterface
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val retrofitService: RetrofitInterface): Repository {

    override suspend fun getAllGithubJavaRepositories(page: String): List<ItemRepository?>? {
        Log.d("Adriano", "Teste 1")
        try {
            val callback = retrofitService.getAllGithubJavaRepositories(page = page)
            if (callback.isSuccessful) {
                callback.body()?.let {
                    return it.items
                }
            } else {
                Log.d("Adriano", "Faio")
            }
        } catch (e: Exception){
            Log.d("Adriano", "Faio aqui: $e")
        }
        return null
    }

    override suspend fun getAllPullRequestsFromRepository(creator: String, repository: String, page: String): List<ItemPullRequest?>? {
        Log.d("Adriano", "Teste 2")
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