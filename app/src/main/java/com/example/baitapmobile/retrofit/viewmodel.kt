package com.example.baitapmobile.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class ServiceViewmodel (): ViewModel(){

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?>get() = _product
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> get() = _uiState

    fun fetchProducts() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val response = RetrofitInstance.service.getProducts()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _uiState.value = UiState.Success(it)
                    } ?: run {
                        _uiState.value = UiState.Error("Phản hồi rỗng dù thành công")
                    }
                } else {
                    _uiState.value = UiState.Error("Lỗi HTTP: ${response.code()}")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Lỗi mạng: ${e.localizedMessage}")
            }
        }
    }




}