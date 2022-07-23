package com.example.bankuishchallenge.data.connection

import com.example.bankuishchallenge.conection.ApiService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ConnectionModuleTest {
    private val mockServer = module {
        single {
            MockWebServer()
        }
    }

    private val okHttpClientModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    var original = chain.request()
                    val url = original.url.newBuilder()
                        .build()
                    original = original.newBuilder().url(url).build()
                    return@Interceptor chain.proceed(original)
                }).build()
        }
    }

    private val retrofitModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(get<MockWebServer>().url("/"))
                .client(get())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }

    private val servicesModule = module {
        factory {
            this.get<Retrofit>().create<ApiService>()
        }
    }

    val all = arrayOf(okHttpClientModule, retrofitModule, servicesModule, mockServer)
}