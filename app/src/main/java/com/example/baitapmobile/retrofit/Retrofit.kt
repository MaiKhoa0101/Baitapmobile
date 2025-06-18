package com.example.baitapmobile.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {

//    private const val BASE_URL = "https://mock.apidog.com/m1/890655-872447-default/"
    private const val coinAPI = "https://api.coingecko.com/api/v3/"
    private const val second_URL = "https://api.coingecko.com/api/v3/"

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(coinAPI)
        .baseUrl(second_URL)
//        .baseUrl(BASE_URL)
        .client(okHttpClient) // ← Đảm bảo dùng client có timeout
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : Service by lazy { retrofit.create(Service::class.java) }
    val coinService : CoinService by lazy { retrofit.create(CoinService::class.java) }

}