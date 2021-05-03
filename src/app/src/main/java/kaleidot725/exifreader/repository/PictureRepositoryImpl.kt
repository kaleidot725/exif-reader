package kaleidot725.exifreader.repository

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.media.ExifInterface
import android.provider.MediaStore
import kaleidot725.exifreader.data.Metadata
import kaleidot725.exifreader.data.Metadata.Companion.METADATA_SETS
import kaleidot725.exifreader.data.Picture

class PictureRepositoryImpl(private val context: Context) :
    PictureRepository {
    private val allPicture: MutableList<Picture> = mutableListOf()

    override fun load() {
        val newAllPicture = fetchALlPicture()
        allPicture.addAll(newAllPicture)
    }

    override fun getAll(): List<Picture> {
        return allPicture.toList()
    }

    override fun getByIndex(index: Int): Picture? {
        return allPicture.getOrNull(index)
    }

    override fun getByPath(path: String): Picture? {
        return allPicture.first { it.path == path }
    }

    override fun count(): Int {
        return allPicture.count()
    }

    override fun getMetadata(picture: Picture): List<Metadata> {
        val inputStream = context.contentResolver.openInputStream(picture.uri) ?: return emptyList()
        val exifInterface = ExifInterface(inputStream)
        val metadataList = mutableListOf<Metadata>()
        METADATA_SETS.forEach { metadata ->
            val attribute = exifInterface.getAttribute(metadata.tag) ?: "Empty"
            metadataList.add(Metadata(metadata.tag, metadata.name, attribute))
        }
        return metadataList
    }

    override fun getIndex(picture: Picture): Int {
        return allPicture.indexOf(picture)
    }

    private fun createCursor(): Cursor? {
        return context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            arrayOf(
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATE_ADDED,
            ),
            null,
            null,
            "${MediaStore.Images.Media.DATE_ADDED} DESC"
        )
    }

    private fun fetchALlPicture(): List<Picture> {
        val pictures = ArrayList<Picture>()
        val cursor = createCursor()
        cursor?.use {
            val idColumns = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val nameColumns = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            while (it.moveToNext()) {
                val id = it.getLong(idColumns)
                val url = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
                val name = it.getString(nameColumns)
                pictures.add(Picture(url, name))
            }
        }
        return pictures
    }
}