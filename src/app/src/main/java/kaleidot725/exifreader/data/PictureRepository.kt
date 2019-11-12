package kaleidot725.exifreader.data


interface PictureRepository {
    fun all(): List<Picture>
    fun count(): Int
}