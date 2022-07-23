package com.example.bankuishchallenge.data.repository

import org.koin.dsl.module

object RepositoryModule {
    private val repositoryModule = module {
        single {
            RepoRepositoriesImpl(get())
        }
    }
    val all = arrayOf(repositoryModule)
}