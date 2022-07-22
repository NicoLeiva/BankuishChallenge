package com.example.bankuishchallenge.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.bankuishchallenge.model.Item
import kotlinx.coroutines.flow.Flow

interface IRepoRepositories {
    fun getAllRepositoriesByLanguage(): Flow<PagingData<Item>>
}