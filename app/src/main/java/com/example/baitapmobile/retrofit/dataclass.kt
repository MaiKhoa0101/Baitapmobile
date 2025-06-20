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



data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val current_price: Double,
    val market_cap: Long,
    val market_cap_rank: Int,
    val fully_diluted_valuation: Long,
    val total_volume: Long,
    val high_24h: Double,
    val low_24h: Double,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val market_cap_change_24h: Double,
    val market_cap_change_percentage_24h: Double,
    val circulating_supply: Double,
    val total_supply: Double,
    val max_supply: Double,
    val ath: Double,
    val ath_change_percentage: Double,
    val ath_date: String,
    val atl: Double,
    val atl_change_percentage: Double,
    val atl_date: String,
    val roi: Any?, // hoặc tạo class ROI nếu có data
    val last_updated: String
)

data class MarketChartResponse(
    val prices: List<List<Double>>
)
