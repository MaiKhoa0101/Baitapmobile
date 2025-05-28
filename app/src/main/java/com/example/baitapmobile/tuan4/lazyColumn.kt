package com.example.baitapmobile.tuan4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.baitapmobile.R
import com.example.baitapmobile.tuan3.baitapvenha3.ComponentCard
import com.example.baitapmobile.tuan3.baitapvenha3.SectionTitle



@Composable
fun StartScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the button to the bottom

        // Image section
        Icon(
            painter = painterResource(id = R.drawable.root), // Replace with your image resource
            contentDescription = "Navigation Logo",
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 16.dp),
            tint = Color.Unspecified
        )

        // Title
        Text(
            text = "Navigation ",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.Black
        )

        // Description
        Text(
            text = "is a framework that simplifies the implementation " +
                    "of navigation between different UI components " +
                    "(activities, fragments, or composables) in an app",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the button to the bottom

        // Push Button
        Button(
            onClick = { navHostController.navigate("list1") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)), // Blue color
            shape = RoundedCornerShape(50)
        ) {
            Text(
                text = "I'm ready",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the button to the bottom

    }
}


@Composable
fun Screen2(navHostController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        item {
            Spacer(modifier = Modifier.height(46.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                IconButton(
                    onClick = { navHostController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrowback),
                        contentDescription = "Back",
                        tint = Color.Unspecified
                    )
                }

                Text(
                    text = "LazyColumn",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xDD2196F3),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        items(100) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Card nằm bên dưới
                ComponentCard(
                    title = item.toString(),
                    "The only way to do great work is to love what you do."
                ) {
                    navHostController.navigate("screen3")
                }


            }
        }
    }
}

@Composable
fun Screen3(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(46.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            IconButton(
                onClick = { navHostController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = "Back",
                    tint = Color.Unspecified
                )
            }

            Text(
                text = "Images",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xDD2196F3),
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("“The only way to do great work ", textAlign = TextAlign.Center)
        Text("“is to love what you do”", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(26.dp))


        Image(
            painter = painterResource(id = R.drawable.expimage),
            contentDescription = "Hinh anh 1"
        )
        Spacer(modifier = Modifier.height(30.dp))
        // Button at the start
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color(0xDD2196F3))
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 16.dp)
                .clickable{navHostController.navigate("home")},
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Back to root", color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp)
        }
    }
}