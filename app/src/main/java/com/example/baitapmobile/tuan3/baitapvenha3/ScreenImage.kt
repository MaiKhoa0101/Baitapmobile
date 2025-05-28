package com.example.baitapmobile.tuan3
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.baitapmobile.R

@Composable
fun ImageScreen(navController: NavController) {
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
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                // Text centered within the row
                Text(
                    text = "Detail",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xDD2196F3),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Image(
            painter = painterResource(id = R.drawable.expimage),
            contentDescription = "Hinh anh 1"
        )
        Text("“The only way to do great work \n" +
                "is to love what you do”",
            textAlign = TextAlign.Center)
        Image(
            painter = painterResource(id = R.drawable.h2),
            contentDescription = "Hinh anh 2"
        )
        Text("In app", textAlign = TextAlign.Center)

    }
}

