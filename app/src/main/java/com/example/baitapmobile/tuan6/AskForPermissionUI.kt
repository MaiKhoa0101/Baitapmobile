package com.example.baitapmobile.tuan6

import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.baitapmobile.R

@Composable
fun RequestPermissionUI(navHostController: NavHostController) {
    val context = LocalContext.current
    var requestRight by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Đã cấp quyền vị trí", Toast.LENGTH_SHORT).show()
            requestRight = checkPermission(context)
        } else {
            Toast.makeText(context, "Từ chối quyền vị trí", Toast.LENGTH_SHORT).show()
        }
        showDialog = false
    }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Đã cấp quyền camera", Toast.LENGTH_SHORT).show()
            requestRight = checkPermission(context)
        } else {
            Toast.makeText(context, "Từ chối quyền camera", Toast.LENGTH_SHORT).show()
        }
        showDialog = false
    }

    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "Đã cấp quyền thông báo", Toast.LENGTH_SHORT).show()
            requestRight = checkPermission(context)
        } else {
            Toast.makeText(context, "Từ chối quyền thông báo", Toast.LENGTH_SHORT).show()
        }
        showDialog = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = com.example.baitapmobile.R.drawable.bgafp),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(0.8f),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF58229)),
                    onClick = {
                        requestRight = checkPermission(context)
                        if (requestRight != "All right request") {
                            showDialog = true
                        }
                    }
                ) {
                    Text(text = "Yêu cầu quyền")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .border(1.dp, Color(0xFFF58229), RoundedCornerShape(20.dp))
                        .fillMaxWidth(0.8f),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
                    onClick = {
                        // Navigate to next screen or perform action
                        navHostController.navigate("next_screen")
                    }
                ) {
                    Text(text = "Tiếp tục", color = Color(0xFFF58229))
                }
            }
        }

        // Show dialog when permission is needed
        if (showDialog) {
            when (requestRight) {
                "Request Location Permission" -> {
                    PopUpRequestRight(
                        image = com.example.baitapmobile.R.drawable.logo_location,
                        name = "Vị trí",
                        description = "Cần quyền chia sẻ vị trí để tiếp tục",
                        onAllow = {
                            locationPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                        },
                        onSkip = {
                            showDialog = false
                        },
                        onDismiss = {
                            showDialog = false
                        }
                    )
                }
                "Request Camera Permission" -> {
                    PopUpRequestRight(
                        image = com.example.baitapmobile.R.drawable.logo_camera,
                        name = "Camera",
                        description = "Cần quyền camera để tiếp tục",
                        onAllow = {
                            cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
                        },
                        onSkip = {
                            showDialog = false
                        },
                        onDismiss = {
                            showDialog = false
                        }
                    )
                }
                "Request Notification Permission" -> {
                    PopUpRequestRight(
                        image = R.drawable.logo_notification,
                        name = "Thông báo",
                        description = "Cần quyền cho phép gửi thông báo để tiếp tục",
                        onAllow = {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
                            } else {
                                Toast.makeText(context, "Thông báo đã được bật", Toast.LENGTH_SHORT).show()
                                showDialog = false
                            }
                        },
                        onSkip = {
                            showDialog = false
                        },
                        onDismiss = {
                            showDialog = false
                        }
                    )
                }
            }
        }

        // Show success message when all permissions are granted
        if (requestRight == "All right request") {
            LaunchedEffect(requestRight) {
                Toast.makeText(context, "Tất cả quyền đã được cấp!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun PopUpRequestRight(
    image: Int,
    name: String,
    description: String,
    onAllow: () -> Unit,
    onSkip: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = description,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = onAllow,
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF58229)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Cho phép")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = onSkip,
                modifier = Modifier
                    .height(40.dp)
                    .border(1.dp, Color(0xFFF58229), RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.8f),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)),
            ) {
                Text("Bỏ qua", color = Color(0xFFF58229))
            }


        }
    }
}


