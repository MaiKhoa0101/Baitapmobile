package com.example.baitapmobile.tuan3
import androidx.compose.foundation.Image
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.baitapmobile.R

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun PassFieldScreen(navController: NavController) {
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
                    text = "Password Field",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xDD2196F3),
                    textAlign = TextAlign.Center
                )
            }
        }
            Spacer(modifier = Modifier.height(46.dp))
            var pass by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }
            OutlinedTextField(
                shape = RoundedCornerShape(20.dp),
                value = pass,
                onValueChange = { pass = it },
                label = { "Password" },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(
                    '*'
                ),

                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            modifier = Modifier
                                .size(30.dp),
                            painter = painterResource(
                                id = if (passwordVisible) R.drawable.openeye else R.drawable.crosseye
                            ),
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                }
            )
        }
    }


