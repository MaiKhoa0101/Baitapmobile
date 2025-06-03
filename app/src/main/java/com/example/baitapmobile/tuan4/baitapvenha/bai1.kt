package com.example.baitapmobile.tuan4

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun baitap4(navHostController: NavHostController) {
    var i by remember { mutableStateOf(0) }
    val user = listUser[i]
    val listBook = listBookAndItsOwner[user] ?: emptyList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Hệ thống\nQuản lý Thư viện",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))

        SinhVienSection(
            user = user,
            onNext = {
                i = (i + 1) % listUser.size
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        BookSection(user, listBook)
    }
}
@Composable
fun SinhVienSection(user: String, onNext: () -> Unit) {
    Column {
        Text("Sinh viên", fontWeight = FontWeight.Bold)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(15.dp))
            ) {
                Text(
                    user,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                modifier = Modifier
                    .width(110.dp)
                    .height(55.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = { onNext() }
            ) {
                Text("Thay đổi", fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun BookSection(user: String,listBook: List<String>) {

    Column {
        Text("Danh sách sách của $user", fontWeight = FontWeight.Bold)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(8.dp)
        ) {
            for (book in listBook) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(8.dp)
                ){
                    Text(book, modifier = Modifier.padding(4.dp), color = Color.White)

                }

            }
        }
    }
}


var listUser: MutableList<String> = mutableListOf(
    "Mai Nguyen Dang Khoa",
    "Vu Nguyen Phuong",
    "Le Nguyen Minh Phuc",
    "Nguyen Hong Minh",
    "Nguyen Hong Ton",
    "Nguyen Nhu Phuong",
    "Bui Trong Vu"
)

val listBookAndItsOwner: Map<String, List<String>> = mapOf(
    "Mai Nguyen Dang Khoa" to listOf("Toán", "Sử", "Anh", "Lý"),
    "Vu Nguyen Phuong" to listOf("Sách chỉ cách giảm cân", "Toán", "Hoá"),
    "Le Nguyen Minh Phuc" to listOf("Anh", "Cách bắn phi phai hay như bác gấu", "Toán"),
    "Nguyen Hong Minh" to listOf("Toán", "Thể dục"),
    "Nguyen Hong Ton" to listOf("Sách dạy tiếng Phú Yên", "Cách nấu cơm gà Phú Yên"),
    "Nguyen Nhu Phuong" to listOf("Độc lạ Bình Dương", "Độc lạ Bình Thường"),
    "Bui Trong Vu" to listOf("Toán", "Sách chỉ cách tăng cân")
)

var listBook: MutableList<String> = mutableListOf(
    "Toán",
    "Sủ",
    "Anh",
    "Lý",
    "Sách chỉ cách giảm cân",
    "Hoá",
    "Cách bắn phi phai hay như bác gấu",
    "Thể dục",
    "Sách dạy tiếng Phú Yên",
    "Cách nấu cơm gà Phú Yên",
    "Độc lạ Bình Dương",
    "Độc lạ Bình Thường",
    "Sách chỉ cách tăng cân",
    "Đắc nhân tâm"
)