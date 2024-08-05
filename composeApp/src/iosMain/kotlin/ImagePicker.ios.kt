// ImagePickeriOS.kt (iOS Main)

package com.example.imagepicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.useContents
import platform.Foundation.NSData
import platform.Foundation.NSDataBase64EncodingOptions
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding
import platform.UIKit.UIImage
import platform.UIKit.UIImageJPEGRepresentation
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.UIKit.UIViewController
import platform.darwin.NSObject

class ImagePickerViewController : UIViewController() {

    private var onImagePicked: ((ImageBitmap?) -> Unit)? = null

    fun pickImage(onImagePicked: (ImageBitmap?) -> Unit) {
        this.onImagePicked = onImagePicked

        val imagePicker = UIImagePickerController().apply {
            delegate = ImagePickerDelegate(this@ImagePickerViewController)
            sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary
        }
        presentViewController(imagePicker, animated = true, completion = null)
    }

    private class ImagePickerDelegate(val parent: ImagePickerViewController) :
        NSObject(),
        UIImagePickerControllerDelegateProtocol,
        UINavigationControllerDelegateProtocol {

        @ObjCAction
        fun imagePickerController(
            picker: UIImagePickerController,
            didFinishPickingMediaWithInfo: CValue<UIImagePickerControllerDelegateProtocol>
        ) {
            val image = didFinishPickingMediaWithInfo.useContents { UIImage.create(info[UIImagePickerControllerDelegateProtocol.OriginalImage] as UIImage) }
            val bitmap = image?.toImageBitmap()
            parent.dismissViewControllerAnimated(true) {
                parent.onImagePicked?.invoke(bitmap)
            }
        }

        @ObjCAction
        fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
            parent.dismissViewControllerAnimated(true) {
                parent.onImagePicked?.invoke(null)
            }
        }
    }
}

@Composable
actual fun rememberImagePicker(): ImagePicker {
    return remember {
        ImagePickerViewController()
    }
}

fun UIImage.toImageBitmap(): ImageBitmap? {
    val data = UIImageJPEGRepresentation(this, 1.0)?.base64EncodedDataWithOptions(NSDataBase64EncodingOptions())
    val byteArray = data?.bytes?.let { NSData.create(it).dataUsingEncoding(NSUTF8StringEncoding) }
    return byteArray?.let { BitmapFactory.decodeByteArray(it, 0, it.size).asImageBitmap() }
}
