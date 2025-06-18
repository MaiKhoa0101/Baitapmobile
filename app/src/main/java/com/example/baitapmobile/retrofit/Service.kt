package com.example.baitapmobile.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service{
    @GET("v2/product")
    suspend fun getProducts(): Response<Product>

}

interface CoinService {
    @GET("coins/markets?vs_currency=vnd")
    suspend fun getMarketData(): Response<List<Coin>>

    @GET("coins/{id}/market_chart")
    suspend fun getPrices(
        @Path("id") coinId: String,
        @Query("vs_currency") currency: String = "usd",
        @Query("days") days: Int = 1
    ): List<Double>

    @GET("coins/markets")
    suspend fun getCoins(
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 10,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): List<Coin>
}

