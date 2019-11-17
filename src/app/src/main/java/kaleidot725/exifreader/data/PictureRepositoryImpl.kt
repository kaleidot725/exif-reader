package kaleidot725.exifreader.data

import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import java.io.File
import java.lang.Exception

class PictureRepositoryImpl(private val context : Context) : PictureRepository {

    override fun all(): List<Picture> {
        return update()
    }

    override fun get(path: String): Picture? {
        return update().firstOrNull {it.path == path}
    }
    override fun count(): Int {
        val list = update()
        return list.count()
    }

    private fun update(): List<Picture> {
        val list = ArrayList<Picture>()

        try {
            val cursor = context.contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.MediaColumns.DATA),
                null,
                null,
                "${MediaStore.MediaColumns.DATA} DESC"
            )

            if(cursor != null) {
                while (cursor.moveToNext()) {
                    val idx = cursor.getColumnIndex(MediaStore.MediaColumns.DATA)
                    val uri = cursor.getString(idx)
                    list.add(Picture(uri, uri))
                }
            }
        }
        catch (e : Exception) {
            Log.v("TEST", e.toString(), e)
        }

        return list.sortedWith(compareBy { it.name })
    }
}