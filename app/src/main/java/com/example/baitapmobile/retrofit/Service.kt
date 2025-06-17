package com.example.baitapmobile.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface Service{
    @GET("v2/product")
    suspend fun getProducts(): Response<Product>

}