package com.example.bankuishchallenge.data.connection

import com.example.bankuishchallenge.conection.ApiService
import com.example.bankuishchallenge.manager.ResourcesManager
import com.example.bankuishchallenge.model.RepoResponse
import com.example.bankuishchallenge.provider.ObjectProvider
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import kotlin.test.assertEquals

class RepoConnectionTest:KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(*ConnectionModuleTest.all)
    }

    private val server by inject<MockWebServer>()
    private val source by inject<ApiService>()

    @Test
    fun getAllRepoPageOne() = runBlocking {
        val expected = MockResponse().apply {
            setResponseCode(200)
            setBody(ResourcesManager.loadResource("get_allRepos.json"))
        }
        server.enqueue(expected)

        val actual: RepoResponse? = source.getAllRepositoriesByLanguage("kotlin",1,1).body()

        assertEquals(ObjectProvider.Item, actual)
    }
}