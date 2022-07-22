package com.example.bankuishchallenge.model

data class RepoResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)