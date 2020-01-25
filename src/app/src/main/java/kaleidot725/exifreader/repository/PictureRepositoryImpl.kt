package kaleidot725.exifreader.repository

import android.content.Context
import android.provider.MediaStore
import android.util.Log
import kaleidot725.exifreader.data.Picture

class PictureRepositoryImpl(private val context: Context) :
    PictureRepository {
    private val list: MutableList<Picture> = mutableListOf()

    override fun load() {
        list.addAll(update())
    }

    override fun all(): List<Picture> {
        return list.toList()
    }

    override fun get(path: String): Picture? {
        return list.firstOrNull { it.path == path }
    }

    override fun count(): Int {
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

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    val idx = cursor.getColumnIndex(MediaStore.MediaColumns.DATA)
                    val uri = cursor.getString(idx)
                    list.add(Picture(uri, uri))
                }
            }
        } catch (e: Exception) {
            Log.v("TEST", e.toString(), e)
        }

        return list.sortedWith(compareBy { it.name })
    }
}