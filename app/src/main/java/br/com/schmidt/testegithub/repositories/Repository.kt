package br.com.schmidt.testegithub.repositories

import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository

interface Repository {

    suspend fun getAllGithubJavaRepositories(page: String): List<ItemRepository?>?

    suspend fun getAllPullRequestsFromRepository(creator: String, repository: String, page: String): List<ItemPullRequest?>?
}