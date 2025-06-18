package com.example.baitapmobile.tuan6.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baitapmobile.retrofit.Coin
import com.example.baitapmobile.retrofit.RetrofitInstance
import com.example.baitapmobile.retrofit.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    private val _coins = MutableStateFlow<List<Coin>>(emptyList())
    val coins: StateFlow<List<Coin?>> = _coins
    private val _prices = MutableStateFlow<List<Double>>(emptyList())
    val prices: StateFlow<List<Double>> = _prices
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> get() = _uiState

    fun fetchCoins() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                while (true) {
                    val response = RetrofitInstance.coinService.getMarketData()
                    if (response.isSuccessful) {
                        response.body()?.let {
                            _coins.value = response.body() ?: emptyList()
                        }
                    } else {
                        _uiState.value = UiState.Error("Lỗi HTTP: ${response.code()}")
                    }
                    println("Ket qua lay ra dc: " + _coins.value)
                    delay(2000)
                }
            } catch (e: Exception) {
                Log.e("CoinViewModel", "Lỗi mạng: ${e.localizedMessage}")
            }
        }
    }
    fun loadChartPrices(coinId: String) {
        viewModelScope.launch {
            try {
                _prices.value = RetrofitInstance.coinService.getPrices(coinId)
                println("Ket qua PRICE lay ra dc: " + _prices.value)
            } catch (e: Exception) {
                Log.e("CoinViewModel", "Error loading chart", e)
            }
        }
    }
}