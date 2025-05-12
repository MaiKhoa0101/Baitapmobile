package com.example.baitapmobile.bai1

import android.location.Address
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitapmobile.R


@Composable
fun Bai1(name: String, avatar: Int, address: String, modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier= Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Icon(
                Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = "Quay ve",
                modifier = Modifier
                    .clickable{

                    }
                    .border(2.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
                    .size(50.dp)
                    .padding(10.dp)

            )
            Icon(
                painter = painterResource(R.drawable.editicon),
                contentDescription = "Quay ve",
                modifier = Modifier
                    .clickable{

                    }
                    .border(2.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
                    .size(50.dp)
                    .padding(10.dp)
            )
        }



        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Image(
                painterResource(avatar), contentDescription = "",
                modifier = Modifier.padding(30.dp).clip(CircleShape).size(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                name,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                address,
                fontSize = 20.sp
            )
        }
    }
}
