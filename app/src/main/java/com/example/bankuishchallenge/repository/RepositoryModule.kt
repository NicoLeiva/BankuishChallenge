package com.example.bankuishchallenge.repository

import org.koin.dsl.module

object RepositoryModule {
    private val repositoryModule = module {
        single<IRepoRepositories>{
            RepoRepositoriesImpl(get())
        }
    }
    val all = arrayOf(repositoryModule)
}