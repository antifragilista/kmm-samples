import androidx.compose.foundation.Image
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import com.example.imagepicker.rememberImagePicker

@Composable
fun ImagePickerScreen() {

    val imagePicker = rememberImagePicker()
    val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }

    Button(onClick = { imagePicker.pickImage { imageBitmap.value = it } }) {
        Text("Pick Image")
    }

    imageBitmap.value?.let { bitmap ->
        Image(bitmap = bitmap, contentDescription = null)
    }
}

