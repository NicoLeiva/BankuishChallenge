package com.example.bankuishchallenge.repository

import androidx.paging.PagingData
import com.example.bankuishchallenge.model.Item
import kotlinx.coroutines.flow.Flow

interface IRepoRepositories {
    suspend fun getAllRepositoriesByLanguage(): Flow<PagingData<Item>>
}