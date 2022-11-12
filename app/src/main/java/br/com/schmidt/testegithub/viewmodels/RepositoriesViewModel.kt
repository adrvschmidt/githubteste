package br.com.schmidt.testegithub.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RepositoriesViewModel : ViewModel() {

    private val repositoriesMutableLiveData = MutableLiveData<ArrayList<String>>()

    val repositoriesLiveData: LiveData<ArrayList<String>> get() = repositoriesMutableLiveData

    val teste = arrayListOf("Ola1", "Ola2", "Ola3","Ola4", "Ola5", "Ola6", "Ola7", "Ola8", "Ola9", "Ola10", "Ola11")

    fun getRepositories(){
        repositoriesMutableLiveData.postValue(teste)
    }
}