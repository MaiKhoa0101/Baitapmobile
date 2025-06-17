package com.example.baitapmobile.tuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil3.compose.AsyncImage
import com.example.baitapmobile.retrofit.ServiceViewmodel
import com.example.baitapmobile.retrofit.UiState


@Composable
fun bai5_2() {
    val service: ServiceViewmodel = viewModel(factory = viewModelFactory {
        initializer { ServiceViewmodel() }
    })
    val uiState by service.uiState.collectAsState()
    var reset by remember { mutableStateOf(false) }
    LaunchedEffect(Unit,reset) {
        service.fetchProducts()
    }

    when (uiState) {
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is UiState.Error -> {
            Text(
                text = (uiState as UiState.Error).message,
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
        is UiState.Success -> {
            val product = (uiState as UiState.Success).product
            println(product)
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 30.dp, horizontal = 20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                item { Text("ProductDetail") }
                item {
                    AsyncImage(
                        model = product.imgURL,
                        contentDescription = "Anh san pham",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Text(
                        product.imgURL
                    )

                    Text(
                        text = product.name,
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(text = "Giá: ${product.price} VND",
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red)
                    Column(
                        modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(Color.LightGray).padding(30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = product.des)
                    }
                    Button(
                        onClick ={
                            reset=!reset
                        }
                    ) {Text("Reset") }
                }
            }
        }
    }
}
