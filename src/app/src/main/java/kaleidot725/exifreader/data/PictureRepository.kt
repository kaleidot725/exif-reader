package kaleidot725.exifreader.data


interface PictureRepository {
    fun load()
    fun all(): List<Picture>
    fun get(path: String): Picture?
    fun count(): Int
}