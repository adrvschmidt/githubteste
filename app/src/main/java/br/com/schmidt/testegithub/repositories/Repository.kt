package br.com.schmidt.testegithub.repositories

interface Repository {

    suspend fun getAllGithubJavaRepositories()

    suspend fun getAllPullRequestsFromRepository()
}