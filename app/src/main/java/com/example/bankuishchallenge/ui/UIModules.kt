package com.example.bankuishchallenge.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {
    private val module = module {
        viewModel{
            RepoViewModel(get())
        }
    }
    val all = arrayOf(module)
}