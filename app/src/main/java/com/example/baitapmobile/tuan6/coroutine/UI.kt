package com.example.baitapmobile.tuan6.coroutine

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import com.example.baitapmobile.R
import androidx.compose.runtime.LaunchedEffect
import coil.compose.AsyncImage
import com.example.baitapmobile.retrofit.Coin
import com.example.baitapmobile.retrofit.ServiceViewmodel
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset

@Composable
fun CryptoDashboardScreen(navHostController: NavHostController) {

    val coinViewModel: CoinViewModel = viewModel(factory = viewModelFactory {
        initializer { CoinViewModel() }
    })

    val coins by coinViewModel.coins.collectAsState()
    val prices by coinViewModel.prices.collectAsState()
    val top5Coins = coins.sortedBy { it?.market_cap_rank }.take(5)


    LaunchedEffect(Unit) {
        coinViewModel.fetchCoins()
        //coinViewModel.loadChartPrices("bitcoin")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF10141E))
            .padding(16.dp)
    ) {
        Text("Home", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.breakingnewbg),
            contentDescription = "Breaking News",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Top Coin", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items (top5Coins) { coin ->
                if (coin != null) {
                    FavoriteItem(navHostController,coin,prices)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("All Fluctuations", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(coins) { coin ->
                if (coin != null) {
                    FluctuationItem(coin)
                }
            }
        }
    }
}

@Composable
fun FavoriteItem(navHostController: NavHostController,coin: Coin, prices: List<Double> = emptyList()) {
    Card(
        modifier = Modifier.width(150.dp).clickable{
            navHostController.navigate("coinDetail")
        },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1B2232))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row (
                modifier = Modifier.width(130.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    model = coin.image,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
                Text(coin.symbol.uppercase(), color = Color.White, fontWeight = FontWeight.Medium)
            }
            Row(
                modifier = Modifier.width(130.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                val roundedCurrentPrice = String.format("%.2f", coin.current_price)
                Text("$"+coin.current_price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.White
                )
                val changeColor = if (coin.price_change_percentage_24h >= 0) Color(0xFF4ADE80) else Color.Red
                val roundedChange = String.format("%.2f", coin.price_change_percentage_24h)
                Text(roundedChange,
                    color = changeColor,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(Color(0xFF4ADE80)) // placeholder for chart
            ) {
                if (prices.isNotEmpty()) {
                    SimpleLineChart(
                        prices = prices,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )
                } else {
                    Text("Đang tải dữ liệu biểu đồ...", color = Color.White)
                }
            }
        }
    }
}


@Composable
fun FluctuationItem(coin: Coin) {
    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF1B2232))) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = coin.image,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(coin.symbol.uppercase(), color = Color.White, fontWeight = FontWeight.Bold)
                    Text(coin.name, color = Color.Gray, fontSize = 12.sp)
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(coin.current_price.toString(), color = Color.White)
                val changeColor = if (coin.price_change_percentage_24h >= 0) Color(0xFF4ADE80) else Color.Red
                Text("%${coin.price_change_percentage_24h}", color = changeColor, fontSize = 12.sp)
            }
        }
    }
}


@Composable
fun SimpleLineChart(
    prices: List<Double>,
    modifier: Modifier = Modifier
) {
    val maxPrice = prices.maxOrNull() ?: 1f
    val minPrice = prices.minOrNull() ?: 0f
    val priceRange = maxPrice.toDouble() - minPrice.toDouble()

    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val spacing = width / (prices.size - 1)

        val points = prices.mapIndexed { index, price ->
            val x = index * spacing
            val y = height - ((price.toDouble() - minPrice.toDouble()) / priceRange) * height
            Offset(x, y.toFloat())
        }

        for (i in 0 until points.size - 1) {
            drawLine(
                color = Color.Cyan,
                start = points[i],
                end = points[i + 1],
                strokeWidth = 2f
            )
        }
    }
}
