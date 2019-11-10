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
        "Aperture Value" to ExifInterface.TAG_APERTURE_VALUE,
        "Artist" to ExifInterface.TAG_ARTIST,
        "Bits Per Sample" to ExifInterface.TAG_BITS_PER_SAMPLE,
        "Brightness Value" to ExifInterface.TAG_BRIGHTNESS_VALUE,
        "CFA Patter" to ExifInterface.TAG_CFA_PATTERN,
        "Color Space" to ExifInterface.TAG_COLOR_SPACE,
        "Components Configuration" to ExifInterface.TAG_COMPONENTS_CONFIGURATION,
        "Compressed Bits Per Pixel" to ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL,
        "Contrast" to ExifInterface.TAG_CONTRAST,
        "Copyright" to ExifInterface.TAG_COPYRIGHT,
        "Custom Renderd" to ExifInterface.TAG_CUSTOM_RENDERED,
        "Datetime" to ExifInterface.TAG_DATETIME,
        "Datetime Digitized" to ExifInterface.TAG_DATETIME_DIGITIZED,
        "Datetime Original" to ExifInterface.TAG_DATETIME_ORIGINAL,
        "Default Crop Size" to ExifInterface.TAG_DEFAULT_CROP_SIZE,
        "Device Setting Description" to ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION,
        "Digital Zoom Ratio" to ExifInterface.TAG_DIGITAL_ZOOM_RATIO,
        "DNG Version" to ExifInterface.TAG_DNG_VERSION,
        "EXIF Version" to ExifInterface.TAG_EXIF_VERSION,
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
        "Focal Plane Y Resolution" to ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION,
        "F Number" to ExifInterface.TAG_F_NUMBER,
        "Gain Control" to ExifInterface.TAG_GAIN_CONTROL,
        "Altitude" to ExifInterface.TAG_GPS_ALTITUDE,
        "Altitude Ref" to ExifInterface.TAG_GPS_ALTITUDE_REF,
        "Area Information" to ExifInterface.TAG_GPS_AREA_INFORMATION,
        "Date Stamp" to ExifInterface.TAG_GPS_DATESTAMP,
        "Dest Bearing" to ExifInterface.TAG_GPS_DEST_BEARING,
        "Dest Bearing Ref" to ExifInterface.TAG_GPS_DEST_BEARING_REF,
        "Distance" to ExifInterface.TAG_GPS_DEST_DISTANCE,
        "Distance Ref" to ExifInterface.TAG_GPS_DEST_DISTANCE_REF,
        "Latitude" to ExifInterface.TAG_GPS_DEST_LATITUDE,
        "Latitude Ref" to ExifInterface.TAG_GPS_DEST_LATITUDE_REF,
        "Longitude" to ExifInterface.TAG_GPS_DEST_LONGITUDE,
        "Longitude Ref" to ExifInterface.TAG_GPS_DEST_LONGITUDE_REF,
        "Differential" to ExifInterface.TAG_GPS_DIFFERENTIAL,
        "DOP" to ExifInterface.TAG_GPS_DOP,
        "Img Direction" to ExifInterface.TAG_GPS_IMG_DIRECTION,
        "Img Direction Ref" to ExifInterface.TAG_GPS_IMG_DIRECTION_REF,
        "Latitude" to ExifInterface.TAG_GPS_LATITUDE,
        "Latitude Ref" to ExifInterface.TAG_GPS_LATITUDE_REF,
        "Longitude" to ExifInterface.TAG_GPS_LONGITUDE,
        "Longitude Ref" to ExifInterface.TAG_GPS_LONGITUDE_REF,
        "Map Datum" to ExifInterface.TAG_GPS_MAP_DATUM,
        "Measure Mode" to ExifInterface.TAG_GPS_MEASURE_MODE,
        "Processing Method" to ExifInterface.TAG_GPS_PROCESSING_METHOD,
        "Satellites" to ExifInterface.TAG_GPS_SATELLITES,
        "Speed" to ExifInterface.TAG_GPS_SPEED,
        "Speed Ref" to ExifInterface.TAG_GPS_SPEED_REF,
        "Status" to ExifInterface.TAG_GPS_STATUS,
        "TimeStamp" to ExifInterface.TAG_GPS_TIMESTAMP,
        "TrackRef" to ExifInterface.TAG_GPS_TRACK_REF,
        "VersionId" to ExifInterface.TAG_GPS_VERSION_ID
        )

    private fun createDrawableFromAssets(assetsName: String) : Drawable {
        val inputStream = assets.open("sample.jpg")
        return Drawable.createFromStream(inputStream, null)
    }

    private fun createExifArrayFromAssetsFile(assetsName : String) : ArrayList<String> {
        val inputStream = assets.open("sample.jpg")
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
