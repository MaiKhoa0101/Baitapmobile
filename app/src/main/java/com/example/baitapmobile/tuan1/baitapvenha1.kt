package com.example.baitapmobile.tuan1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaiTapVeNha1(name: String, avatar: Int, text: String, modifier: Modifier = Modifier.Companion){
    Column(
        modifier = Modifier.Companion.padding(10.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.Companion.height(40.dp))

        Column(
            modifier = Modifier.Companion.fillMaxSize().padding(4.dp),
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Image(
                painterResource(avatar), contentDescription = "",
                modifier = Modifier.Companion.padding(30.dp).clip(CircleShape).size(200.dp)
            )
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Text(
                name,
                fontWeight = FontWeight.Companion.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Text(
                text,
                fontSize = 13.sp,
                color = Color.Companion.Gray
            )
        }
    }
}