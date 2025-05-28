package com.example.baitapmobile.tuan3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.baitapmobile.R
import kotlinx.coroutines.delay

@Composable
fun baituan3(){
    var isClicked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth().height(900.dp).padding(vertical = 300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
            ){
        Text(
            "My First App",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        if (isClicked==true){
            Text(
                "I'm\nMai Nguyễn Đăng Khoa",
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
        else{
            Text("Welcome")
        }
        Button(
            onClick = {isClicked=true},
            modifier = Modifier.height(50.dp).width(200.dp)
        ) {
            Text("Say Hi!", fontSize = 20.sp)
        }
    }
}




@Composable
fun BaiTuan3_2(navController3: NavHostController) {
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
            text = "Jetpack Compose",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.Black
        )

        // Description
        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the button to the bottom

        // Push Button
        Button(
            onClick = { navController3.navigate("list1") },
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
fun GetStarted1(navController : NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Cyan, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )

            }
            TextButton(onClick = { navController.navigate("getstarted3") }) {
                Text(text = "Skip", color = Color.Cyan, fontSize = 16.sp)
            }
        }

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart1), // Replace with your image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
//            contentScale = ContentScale.Fit
        )

        // Title
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Description
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Next Button
        Button(
            onClick = { navController.navigate("getstarted2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text(text = "Next", color = Color.White, fontSize = 16.sp)
        }
    }
}




@Composable
fun GetStarted2(navController : NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Cyan, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )

            }
            TextButton(onClick = { navController.navigate("getstarted3") }) {
                Text(text = "Skip", color = Color.Cyan, fontSize = 16.sp)
            }
        }

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart2), // Replace with your actual image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        // Title
        Text(
            text = "Increase Work Effectiveness",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Description
        Text(
            text = "Time management and the determination of more important tasks will give your job statistics better and always improve.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Push buttons to bottom

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button (Circular Icon)
            IconButton(
                onClick = {navController.navigate("getstarted1")},
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Cyan, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            // Next Button (Rounded Rectangle)
            Button(
                onClick = {navController.navigate("getstarted3")},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp)
            ) {
                Text(text = "Next", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}




@Composable
fun GetStarted3(navController : NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .padding(30.dp)
                )
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(color = Color.Cyan, shape = CircleShape)
                        .padding(30.dp)
                )

            }
            TextButton(onClick = { navController.navigate("getstarted3") }) {
                Text(text = "Skip", color = Color.Cyan, fontSize = 16.sp)
            }
        }

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.getstart3), // Replace with your image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
//            contentScale = ContentScale.Fit
        )

        // Title
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Description
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button (Circular Icon)
            IconButton(
                onClick = {navController.navigate("getstarted2")},
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Cyan, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            // Next Button (Rounded Rectangle)
            Button(
                onClick = {navController.navigate("splash")},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp)
            ) {
                Text(text = "Next", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

