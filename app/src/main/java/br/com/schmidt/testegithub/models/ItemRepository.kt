package br.com.schmidt.testegithub.models

import com.google.gson.annotations.SerializedName

data class ItemRepository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val stargazers_count: Long,
    @SerializedName("score") val score: Double,
    @SerializedName("owner") val owner: OwnerRepositoryObject,
    @SerializedName("url") val url: String,
    @SerializedName("forks_count") val forks_count: Long,
)
