package br.com.schmidt.testegithub.ui.repositories

import br.com.schmidt.testegithub.ui.models.ItemPullRequest
import br.com.schmidt.testegithub.ui.models.ItemRepository
import br.com.schmidt.testegithub.ui.models.ListRepositoriesObject

interface Repository {

    suspend fun getAllGithubJavaRepositories(page: Int): ListRepositoriesObject?

    suspend fun getAllPullRequestsFromRepository(creator: String, repository: String, page: Int): List<ItemPullRequest>?
}