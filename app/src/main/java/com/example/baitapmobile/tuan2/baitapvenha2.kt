package com.example.baitapmobile.tuan2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaiTapVeNha2(modifier: Modifier){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    var showValidationError by remember { mutableStateOf(false) }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxHeight().fillMaxWidth().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Bài tập về nhà 02",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier.height(180.dp).background(Color.LightGray).padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Họ và tên",
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        showResult=false},
                    modifier = Modifier.clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .width(200.dp),
                    shape = RoundedCornerShape(15.dp)
                )
            }
            if (showResult) {
                // Hiện cảnh báo nếu đã nhấn nút và dữ liệu không hợp lệ
                if (showValidationError && (name.isBlank() || name.all { char -> char.isLetter() })) {
                    Text("Tên không đúng định dạng", color = Color.Red)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Tuổi",
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = age,
                    onValueChange = {
                        age = it
                        showResult=false },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color.White)
                        .width(200.dp),
                    shape = RoundedCornerShape(15.dp)
                )
            }

            if (showResult) {
                // Hiện cảnh báo nếu đã nhấn nút và dữ liệu không hợp lệ
                if (showValidationError && (age.isBlank() || !age.all { char -> char.isDigit() } || age.toInt() < 0)) {
                    Text("Số tuổi không hợp lệ", color = Color.Red)
                } else if (showValidationError && age.isNotBlank()) {
                    if (age.toInt() < 2) {
                        Text("Là em bé", color = Color.Green)
                    } else if (age.toInt() <= 6) {
                        Text("Là trẻ em", color = Color.Green)
                    } else if (age.toInt() <= 65) {
                        Text("Là người lớn", color = Color.Green)
                    } else {
                        Text("Là người già", color = Color.Green)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
            Button(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.width(200.dp).height(50.dp),
                onClick = {
                    showValidationError = true
                    showResult=true
                }
            ) {
                Text("Kiểm tra")
            }
    }
}