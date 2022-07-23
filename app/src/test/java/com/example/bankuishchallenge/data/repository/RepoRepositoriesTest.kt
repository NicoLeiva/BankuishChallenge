package com.example.bankuishchallenge.data.repository

import com.example.bankuishchallenge.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertNotNull

class RepoRepositoriesTest: KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create{
        modules(*RepositoryModulesTest.all)
    }

    private val repository by inject<RepoRepositoriesImpl>()

    @Test
    fun getRepos(): Unit = runBlocking{
        val actual = repository.getAllRepositoriesByLanguage("kotlin")
        val expected = ObjectProvider.Item
        assertNotNull(expected)
        assertNotNull(actual)
    }
}