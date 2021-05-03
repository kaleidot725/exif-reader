package kaleidot725.exifreader.data

import android.net.Uri
import java.io.File

data class Picture(val uri: Uri, val name: String) {
    val path: String = uri.toString()
    val file: File = File(path)
}