package com.example.bankuishchallenge.data.repository

import com.example.bankuishchallenge.conection.ConnectionModule
import com.example.bankuishchallenge.ui.UIModules
import com.example.bankuishchallenge.data.paging.PagingModule

object RepositoryModulesTest {

    val all = arrayOf(
        *ConnectionModule.all,
        *RepositoryModule.all,
        *UIModules.all,
        *PagingModule.all
    )
}