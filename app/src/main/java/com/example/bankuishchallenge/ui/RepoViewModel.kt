package com.example.bankuishchallenge.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.bankuishchallenge.data.repository.RepoRepositoriesImpl

class RepoViewModel(private val repository: RepoRepositoriesImpl): ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val repos = currentQuery.switchMap { queryString ->
        repository.getAllRepositoriesByLanguage(queryString).cachedIn(viewModelScope)
    }

    companion object {
        private const val DEFAULT_QUERY = "kotlin"
    }
}