package com.example.bankuishchallenge.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.bankuishchallenge.conection.ApiService
import com.example.bankuishchallenge.data.paging.RepositoryPagingSource
import com.example.bankuishchallenge.data.paging.RepositoryPagingSource.Companion.PAGE_SIZE

class RepoRepositoriesImpl(private val apiService:ApiService):IRepoRepositories{

    override fun getAllRepositoriesByLanguage(query:String) =
        Pager (config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { RepositoryPagingSource(apiService,query) }).liveData


}