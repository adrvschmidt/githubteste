package br.com.schmidt.testegithub.models

import com.google.gson.annotations.SerializedName

data class OwnerRepositoryObject(
    @SerializedName("id") val id: Long,
    @SerializedName("avatar_url") val avatar_url: String
    )
