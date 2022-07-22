package com.example.bankuishchallenge.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.bankuishchallenge.RepositoryPagingSource
import com.example.bankuishchallenge.RepositoryPagingSource.Companion.PAGE_SIZE
import com.example.bankuishchallenge.conection.ApiService
import com.example.bankuishchallenge.model.Item
import kotlinx.coroutines.flow.Flow

class RepoRepositoriesImpl(private val apiService:ApiService):IRepoRepositories {

    override fun getAllRepositoriesByLanguage(): Flow<PagingData<Item>> {
        return Pager (config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { RepositoryPagingSource(apiService) }).flow
    }
}