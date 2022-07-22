package com.example.bankuishchallenge.conection

import com.example.bankuishchallenge.model.RepoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("repositories")
    suspend fun getAllRepositoriesByLanguage(@Query("q") q:String,
                                             @Query("per_page") perPage:Int,
                                             @Query("page") page:Int): Response<RepoResponse>
}