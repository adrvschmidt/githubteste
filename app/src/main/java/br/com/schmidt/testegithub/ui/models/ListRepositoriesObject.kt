package br.com.schmidt.testegithub.ui.models

import com.google.gson.annotations.SerializedName

data class ListRepositoriesObject(
    @SerializedName("total_count") val total_count: Long,
    @SerializedName("items") val items: List<ItemRepository>
)
