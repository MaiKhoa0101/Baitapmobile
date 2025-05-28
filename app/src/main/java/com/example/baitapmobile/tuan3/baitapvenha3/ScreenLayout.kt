package com.example.baitapmobile.tuan3
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
@Composable
fun LayoutScreen(navController: NavController) {
    var tempLayout by remember { mutableStateOf<String?>(null) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(46.dp))
            Box()
            {
                // Button at the start
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, // Arrow icon
                        contentDescription = "Navigate",
                        tint = Color(0xDD2196F3), // Make the arrow red
                        modifier = Modifier.size(30.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Text centered within the row
                    Text(
                        text = "Layout",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xDD2196F3),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(46.dp))

            // Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { tempLayout = "Column" }) {
                    Text(text = "Column", fontSize = 16.sp)
                }
                Button(onClick = { tempLayout = "Row" }) {
                    Text(text = "Row", fontSize = 16.sp)
                }
                Button(onClick = { tempLayout = "Box" }) {
                    Text(text = "Box", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display example based on selected layout
            when (tempLayout) {
                "Column" -> ExampleColumnLayout()
                "Row" -> ExampleRowLayout()
                "Box" -> ExampleBoxLayout()
            }
        }
    }


    @Composable
    fun ExampleColumnLayout() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val cardColor = CardDefaults.cardColors(containerColor = Color(0xDD2196F3))

            Card(
                modifier = Modifier
                    .width(250.dp)
                    .height(100.dp),
                colors = cardColor
            ) {}

            Spacer(modifier = Modifier.height(8.dp)) // Thêm khoảng cách giữa các Card nếu muốn

            Card(
                modifier = Modifier
                    .width(250.dp)
                    .height(100.dp),
                colors = cardColor
            ) {}

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier
                    .width(250.dp)
                    .height(100.dp),
                colors = cardColor
            ) {}

        }
    }

    @Composable
    fun ExampleRowLayout() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val cardColor = CardDefaults.cardColors(containerColor = Color(0xDD2196F3))

            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp),
                colors = cardColor
            ) {}

            Spacer(modifier = Modifier.height(8.dp)) // Thêm khoảng cách giữa các Card nếu muốn

            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp),
                colors = cardColor
            ) {}

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp),
                colors = cardColor
            ) {}
        }
    }

    @Composable
    fun ExampleBoxLayout() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xDD2196F3))
            ) {}

            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Red)
            ) {}
        }

    }






