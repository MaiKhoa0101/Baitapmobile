package com.example.baitapmobile.tuan6.coroutine

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.baitapmobile.retrofit.Coin


val coinDef = Coin(
    id = "",
    symbol = "",
    name = "",
    image = "",
    current_price = 0.0,
    market_cap = 0.0.toLong(),
    market_cap_rank = 0,
    fully_diluted_valuation = 0.0.toLong(),
    total_volume = 0.0.toLong(),

    high_24h = 0.0,
    low_24h = 0.0,
    price_change_24h = 0.0,
    price_change_percentage_24h = 0.0,

    market_cap_change_24h = 0.0,
    market_cap_change_percentage_24h = 0.0,
    circulating_supply = 0.0,

    total_supply = 0.0,
    max_supply = 0.0,
    ath = 0.0,
    ath_change_percentage = 0.0,
    ath_date = "",
    atl = 0.0,
    atl_change_percentage = 0.0,
    atl_date = "",
    roi = null,
    last_updated = ""
)
@Composable
fun InforCoint(coin:Coin = coinDef ){
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text("ID: "+coin.id)
        Text("Name: "+coin.name)
        Text("Symbol: "+coin.symbol)
        Text("Image: "+coin.image)
        Text("Current_price: "+coin.current_price)
        Text("Market_cap: "+coin.market_cap)
        Text("Market_cap_rank: "+coin.market_cap_rank)
        Text("Fully_diluted_valuation: "+coin.fully_diluted_valuation)
        Text("Total_volume: "+coin.total_volume)
        Text("High_24h: "+coin.high_24h)
        Text("Low_24h: "+coin.low_24h)
        Text("Price_change_24h: "+coin.price_change_24h)
        Text("Price_change_percentage_24h: "+coin.price_change_percentage_24h)
        Text("Market_cap_change_24h: "+coin.market_cap_change_24h)
        Text("Market_cap_change_percentage_24h: "+coin.market_cap_change_percentage_24h)
        Text("Circulating_supply: "+coin.circulating_supply)
        Text("Total_supply: "+coin.total_supply)
        Text("Max_supply: "+coin.max_supply)
        Text("Ath: "+coin.ath)
        Text("Ath_change_percentage: "+coin.ath_change_percentage)
        Text("Ath_date: "+coin.ath_date)
        Text("Atl: "+coin.atl)
        Text("Atl_change_percentage: "+coin.atl_change_percentage)
        Text("Atl_date: "+coin.atl_date)
        Text("Roi: "+coin.roi)
        Text("Last_updated: "+coin.last_updated)

    }
}