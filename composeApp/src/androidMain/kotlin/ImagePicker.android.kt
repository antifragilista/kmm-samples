package com.example.imagepicker

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun rememberImagePicker(): ImagePicker {
    val context = LocalContext.current

    // 이미지 선택 런처 생성
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        val bitmap = uri?.let {
            val inputStream = context.contentResolver.openInputStream(it)
            BitmapFactory.decodeStream(inputStream)?.asImageBitmap()
        }
        // onImagePicked를 기억하고 이를 통해 결과 전달
        bitmap
    }

    // ImagePicker 인터페이스 구현
    return remember {
        object : ImagePicker {
            override fun pickImage(onImagePicked: (ImageBitmap?) -> Unit) {
                launcher.launch("image/*")
            }
        }
    }
}