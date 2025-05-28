package com.example.baitapmobile.tuan3.baitapvenha3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UIComponentsList(navController: NavController) { // Nhận NavController từ AppNavigation
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Spacer(modifier = Modifier.height(46.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "UI Components List",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xDD2196F3),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle("Display")
        ComponentCard("Text", "Displays text") { navController.navigate("text") }
        ComponentCard("Image", "Displays an image") { navController.navigate("image") }

        SectionTitle("Input")
        ComponentCard("TextField", "Input field for text") { navController.navigate("textfield") }
        ComponentCard("PasswordField", "Input field for passwords") { navController.navigate("passwordfield") }

        SectionTitle("Layout")
        ComponentCard("Collumn, Row, Box", "Arranges elements by 3 layout") { navController.navigate("layout") }
        SectionTitle("ScaffoldScreen")
        ComponentCard("Scaffold", "Topbar and footbar") { navController.navigate("scaffold") }

    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 16.dp),
    )
}

@Composable
fun ComponentCard(title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0x772196F3))
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal =  24.dp, vertical = 10.dp)
            ) {
                Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = description, fontSize = 16.sp)
            }
        }
    }
}

