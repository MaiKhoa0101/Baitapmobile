package com.example.baitapmobile.tuan2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun bai2(modifier: Modifier){
    var text by remember { mutableStateOf("") }

    var showValidationError by remember { mutableStateOf(false) }
    Row (
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "Thực hành 02",
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
            )
            // Hiện cảnh báo nếu đã nhấn nút và dữ liệu không hợp lệ
            if (showValidationError && (text.isBlank() || !text.contains('@'))) {
                Text("Email không đúng định dạng", color = Color.Red)
            }
            Button(
                modifier= Modifier.width(200.dp),
                onClick = {
                    showValidationError= true
                }
            ) {
                Text("Kiểm tra")
            }
        }

    }
}