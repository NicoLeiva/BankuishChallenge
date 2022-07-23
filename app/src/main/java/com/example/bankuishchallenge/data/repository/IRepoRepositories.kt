package com.example.bankuishchallenge.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.bankuishchallenge.model.Item

interface IRepoRepositories {
    fun getAllRepositoriesByLanguage(query:String): LiveData<PagingData<Item>>
}