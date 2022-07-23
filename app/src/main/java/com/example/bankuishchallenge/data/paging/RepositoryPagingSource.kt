package com.example.bankuishchallenge.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.bankuishchallenge.conection.ApiService
import com.example.bankuishchallenge.model.Item

class RepositoryPagingSource(
    private val apiService: ApiService,
    private val query: String
) : PagingSource<Int, Item>() {

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val nextPageNumber = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.getAllRepositoriesByLanguage(query, PAGE_SIZE, nextPageNumber)
            val nextKey = if (response.body()?.items.isNullOrEmpty()) {
                null
            } else {
                nextPageNumber + (params.loadSize / PAGE_SIZE)
            }

            LoadResult.Page(
                data = response.body()?.items ?: emptyList(),
                prevKey = if (nextPageNumber == FIRST_PAGE_INDEX) null else nextKey,
                nextKey = nextKey,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
        const val PAGE_SIZE = 20
    }
}