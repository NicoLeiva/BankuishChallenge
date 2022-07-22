package com.example.bankuishchallenge.conection

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ConnectionModule {
    private const val baseUrl = "https://api.github.com/search/"

    private val okHttpClientModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    var original = chain.request()
                    val url = original.url().newBuilder()
                        .build()
                    original = original.newBuilder().url(url).build()
                    return@Interceptor chain.proceed(original)
                }).build()
        }
    }
    private val retrofitModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    private val serviceModule = module{
        factory {
            this.get<Retrofit>().create<ApiService>()
        }
    }
    val all = arrayOf(okHttpClientModule,retrofitModule, serviceModule)
}