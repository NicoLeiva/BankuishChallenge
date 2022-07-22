package com.example.bankuishchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.bankuishchallenge.model.Item
import com.example.bankuishchallenge.repository.IRepoRepositories
import kotlinx.coroutines.flow.Flow

class RepoViewModel(private val repository: IRepoRepositories): ViewModel() {

    fun getAllRepositoriesByLanguage(): Flow<PagingData<Item>> {
        return repository.getAllRepositoriesByLanguage().cachedIn(viewModelScope)
    }

}