package kaleidot725.exifreader

import android.graphics.drawable.Drawable
import android.media.ExifInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val exifMap = mapOf(
        "Datetime" to ExifInterface.TAG_DATETIME,
        "Exposure Bias Vluae" to ExifInterface.TAG_EXPOSURE_BIAS_VALUE,
        "Exposure Index" to ExifInterface.TAG_EXPOSURE_INDEX,
        "Exposure Mode" to ExifInterface.TAG_EXPOSURE_MODE,
        "Exposure Program" to ExifInterface.TAG_EXPOSURE_PROGRAM,
        "Exposure Time" to ExifInterface.TAG_EXPOSURE_TIME,
        "File Source" to ExifInterface.TAG_FILE_SOURCE,
        "Flash" to ExifInterface.TAG_FLASH,
        "FlashPix Version" to ExifInterface.TAG_FLASHPIX_VERSION,
        "Flash Energy" to ExifInterface.TAG_FLASH_ENERGY,
        "Focal Length" to ExifInterface.TAG_FOCAL_LENGTH,
        "Folcal Length in 35MM Film" to ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM,
        "Focal Plane Resolution Unit" to ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT,
        "Focal Plane X Resolution" to ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION,
        "Focal Plane Y Resolution" to ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION
        )

    private fun createDrawableFromAssets(assetsName: String) : Drawable {
        val inputStream = assets.open(assetsName)
        return Drawable.createFromStream(inputStream, null)
    }

    private fun createExifArrayFromAssetsFile(assetsName : String) : ArrayList<String> {
        val inputStream = assets.open(assetsName)
        val exifInterface = ExifInterface(inputStream)
        return arrayListOf<String>().also { array ->
            exifMap.forEach { item ->
                array.add("${item.key} : ${exifInterface.getAttribute(item.value)}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image_view)
        val drawable =  createDrawableFromAssets("sample.jpg")
        image.setImageDrawable(drawable)

        val list = findViewById<ListView>(R.id.exif_data_list)
        val array = createExifArrayFromAssetsFile("sample.jpg")
        list.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array)
    }
}
