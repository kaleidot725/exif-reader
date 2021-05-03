package kaleidot725.exifreader.repository

import kaleidot725.exifreader.data.Metadata
import kaleidot725.exifreader.data.Picture

interface PictureRepository {
    fun load()
    fun getAll(): List<Picture>
    fun getByPath(path: String): Picture?
    fun getByIndex(index: Int): Picture?

    fun count(): Int

    fun getMetadata(picture: Picture): List<Metadata>
    fun getIndex(picture: Picture): Int
}