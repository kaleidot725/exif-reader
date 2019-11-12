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
        return update().reversed()
    }

    override fun count(): Int {
        val list = update()
        return list.count()
    }

    private fun update(): List<Picture> {
        val externalUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val list = ArrayList<Picture>()

        try {
            val cursor = context.contentResolver.query(
                externalUri,
                arrayOf(MediaStore.MediaColumns._ID,  MediaStore.MediaColumns.DATE_MODIFIED),
                null,
                null,
                "${MediaStore.MediaColumns.DATE_MODIFIED} DESC"
            )

            if(cursor != null) {
                while (cursor.moveToNext()) {
                    val id = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns._ID))
                    val uri = ContentUris.withAppendedId(externalUri, id.toLong())
                    list.add(Picture(uri.path, uri.path))
                }
            }
        }
        catch (e : Exception) {
            Log.v("TEST", e.toString(), e)
        }


        return list.sortedWith(compareBy { it.name })
    }
}