package com.example.baitapmobile.tuan3
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.baitapmobile.R

@Composable
fun ScaffoldScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {TopBar(navHostController)},
        bottomBar = {BottomBar()}
    ) { innerPadding->
        Body(Modifier.padding(innerPadding))
    }
}

@Composable
fun TopBar(navHostController: NavHostController){
    Spacer(modifier = Modifier.height(106.dp))
    Column() {


        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.Cyan)
        )
        {
            // Button at the start
            IconButton(
                onClick = { navHostController.popBackStack() }
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
                    text = "Scaffold",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xDD2196F3),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(46.dp))}

}
@Composable
fun Body(modifier: Modifier){
    Column (modifier = modifier){
        Text("Body")
    }}
@Composable
fun BottomBar(){
    Row (
        modifier= Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Cyan),
        horizontalArrangement = Arrangement.Center
    )
    {
        Text("FootBar", textAlign = TextAlign.Center)
    }
}