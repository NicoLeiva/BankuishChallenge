package com.example.bankuishchallenge

import org.koin.dsl.module

object PagingModule {
    private val pagingModule = module {
        single {
            RepositoryPagingSource(get())
        }
    }
    val all = arrayOf(pagingModule)
}