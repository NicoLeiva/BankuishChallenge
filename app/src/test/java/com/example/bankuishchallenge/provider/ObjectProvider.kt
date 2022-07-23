package com.example.bankuishchallenge.provider

import com.example.bankuishchallenge.manager.ResourcesManager
import com.example.bankuishchallenge.model.RepoResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ObjectProvider {

    val Item: RepoResponse = Gson().fromJson(
        ResourcesManager.loadResource("get_allRepos.json"),
        object : TypeToken<RepoResponse>() {}.type
    )
}