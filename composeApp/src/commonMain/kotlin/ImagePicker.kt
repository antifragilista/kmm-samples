// ImagePicker.kt (Common Main)

package com.example.imagepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.ImageBitmap

interface ImagePicker {
    fun pickImage(onImagePicked: (ImageBitmap?) -> Unit)
}

@Composable
expect fun rememberImagePicker(): ImagePicker