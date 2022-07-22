package com.example.bankuishchallenge

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.bankuishchallenge.conection.ApiService
import com.example.bankuishchallenge.model.Item

class RepositoryPagingSource(private val apiService: ApiService):PagingSource<Int, Item>() {

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val pageNumber = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.getAllRepositoriesByLanguage("kotlin", PAGE_SIZE, pageNumber)
            println("PAGE $pageNumber" )
            println("RESPONSE $response" )
           /* val nextKey = if (response.body()?.items.isNullOrEmpty()){
                null
            } else {
                pageNumber + (params.loadSize / PAGE_SIZE)
            }

            */

            LoadResult.Page(data = response.body()?.items ?: emptyList(),
                prevKey = if(pageNumber == FIRST_PAGE_INDEX) null else pageNumber,
                nextKey = pageNumber +1,
            )
        }
        catch (e: Exception){
            println("ERROR ${e.message}")
            LoadResult.Error(e)

        }
    }
    companion object {
        private const val FIRST_PAGE_INDEX = 1
        const val PAGE_SIZE = 20
    }
}