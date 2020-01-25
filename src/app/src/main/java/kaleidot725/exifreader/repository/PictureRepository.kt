package kaleidot725.exifreader.repository

import kaleidot725.exifreader.data.Picture


interface PictureRepository {
    fun load()
    fun all(): List<Picture>
    fun get(path: String): Picture?
    fun count(): Int
}