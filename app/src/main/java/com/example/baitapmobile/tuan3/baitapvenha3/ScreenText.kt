package com.example.baitapmobile.tuan3
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
    fun TextScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
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
                        text = "Text Detail",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xDD2196F3),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 28.sp)) {
                            append("The ")
                        }
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.LineThrough,
                                fontSize = 28.sp
                            )
                        ) {
                            append("quick ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF8000), // Orange
                                fontSize = 32.sp
                            )
                        ) {
                            append("Brown")
                        }
                        append("\n")

                        withStyle(style = SpanStyle(fontSize = 28.sp)) {
                            append("fox j u m p s ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp
                            )
                        ) {
                            append("over")
                        }
                        append("\n")

                        withStyle(style = SpanStyle(fontSize = 28.sp)) {
                            append("the ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontStyle = FontStyle.Italic,
                                fontSize = 28.sp
                            )
                        ) {
                            append("lazy")
                        }
                        withStyle(style = SpanStyle(fontSize = 28.sp)) {
                            append(" dog.",)
                        }
                    },
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(top = 4.dp)
                    .background(Color.Gray)
            )
        }
    }

