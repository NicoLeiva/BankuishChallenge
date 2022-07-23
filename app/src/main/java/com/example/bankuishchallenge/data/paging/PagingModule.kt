package com.example.bankuishchallenge.data.paging

import org.koin.dsl.module

object PagingModule {
    private val pagingModule = module {
        single {
            RepositoryPagingSource(get(),get())
        }
    }
    val all = arrayOf(pagingModule)
}