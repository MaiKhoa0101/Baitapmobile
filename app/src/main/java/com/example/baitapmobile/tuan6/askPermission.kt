package com.example.baitapmobile.tuan6

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat

fun checkPermission(context: Context): String {
    println("Vào check permission")

    // Kiểm tra quyền vị trí trước
    if (ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_DENIED
    ) {
        return "Request Location Permission"
    }

    // Kiểm tra quyền camera
    if (ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_DENIED
    ) {
        return "Request Camera Permission"
    }

    // Kiểm tra quyền thông báo (chỉ từ Android 13+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_DENIED
        ) {
            return "Request Notification Permission"
        }
    }

    return "All right request"
}