package br.com.schmidt.testegithub.utils

class Constants {

    companion object {
        const val BASE_URL = "https://api.github.com/"

        fun returnPage(page: Int?): Int{
            var countPage = 0
            page?.let {
                countPage = it
            }
            return countPage + 1
        }
    }
}