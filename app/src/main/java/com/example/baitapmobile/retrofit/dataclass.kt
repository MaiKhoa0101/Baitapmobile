package com.example.baitapmobile.retrofit

data class Product(
    val id: String,
    val name: String,
    val des: String,
    val price: Double,
    val imgURL: String
)

sealed class UiState {
    object Loading : UiState()
    data class Success(val product: Product) : UiState()
    data class Error(val message: String) : UiState()
}
