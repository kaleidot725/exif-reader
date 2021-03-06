package kaleidot725.exifreader.data

import androidx.exifinterface.media.ExifInterface

data class Metadata(val tag: String, val name: String, var value: String) {
    companion object {
        val METADATA_SETS: List<Metadata> = listOf(
            Metadata(ExifInterface.TAG_APERTURE_VALUE, "APERTUERE VALUE", ""),
            Metadata(ExifInterface.TAG_ARTIST, "ARTIST", ""),
            Metadata(ExifInterface.TAG_BITS_PER_SAMPLE, "BITS PER SAMPLE", ""),
            Metadata(ExifInterface.TAG_BRIGHTNESS_VALUE, "BRIGHTNESS", ""),
            Metadata(ExifInterface.TAG_CFA_PATTERN, "CFA PATTER", ""),
            Metadata(ExifInterface.TAG_COLOR_SPACE, "COLOR SPACE", ""),
            Metadata(ExifInterface.TAG_COMPONENTS_CONFIGURATION, "COMPONENTS CONFIGURATION", ""),
            Metadata(ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, "COMPRESSED BITS PER PIXEL", ""),
            Metadata(ExifInterface.TAG_COMPRESSION, "COMPRESSION", ""),
            Metadata(ExifInterface.TAG_CONTRAST, "CONTRAST", ""),
            Metadata(ExifInterface.TAG_COPYRIGHT, "COPYRIGHT", ""),
            Metadata(ExifInterface.TAG_CUSTOM_RENDERED, "CUSTOM RENDERED", ""),
            Metadata(ExifInterface.TAG_DATETIME, "DATETIME", ""),
            Metadata(ExifInterface.TAG_DATETIME_DIGITIZED, "DATETIME DIGITIZED", ""),
            Metadata(ExifInterface.TAG_DATETIME_ORIGINAL, "DATETIME ORIGINAL", ""),
            Metadata(ExifInterface.TAG_DEFAULT_CROP_SIZE, "DEFAULT CROP SIZE", ""),
            Metadata(
                ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION,
                "DEVICE SETTING DESCRIPTION",
                ""
            ),
            Metadata(ExifInterface.TAG_DIGITAL_ZOOM_RATIO, "DIGITIAL ZOOM RATIO", ""),
            Metadata(ExifInterface.TAG_DNG_VERSION, "DNG VERSION", ""),
            Metadata(ExifInterface.TAG_EXIF_VERSION, "EXIF VERSION", ""),
            Metadata(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, "EXPOSURE BIAS VALUE", ""),
            Metadata(ExifInterface.TAG_EXPOSURE_INDEX, "EXPOSURE INDEX", ""),
            Metadata(ExifInterface.TAG_EXPOSURE_MODE, "EXPOSURE MODE", ""),
            Metadata(ExifInterface.TAG_EXPOSURE_PROGRAM, "EXPOSURE PROGRAM", ""),
            Metadata(ExifInterface.TAG_EXPOSURE_TIME, "EXPOSURE TIME", ""),
            Metadata(ExifInterface.TAG_FILE_SOURCE, "FILE SOURCE", ""),
            Metadata(ExifInterface.TAG_FLASH, "FLASH", ""),
            Metadata(ExifInterface.TAG_FLASHPIX_VERSION, "FLASHPIX VERSION", ""),
            Metadata(ExifInterface.TAG_FLASH_ENERGY, "FLASH ENERGY", ""),
            Metadata(ExifInterface.TAG_FOCAL_LENGTH, "FOCAL LENGTH", ""),
            Metadata(ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, "FOCAL LENGTH IN 35MM FILM", ""),
            Metadata(
                ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT,
                "FOCAL PLANE RESOLUTION UNIT",
                ""
            ),
            Metadata(ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, "FOCAL PLANE X RESOLUTION", ""),
            Metadata(ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, "FOCAL PLANE Y RESOLUTION", ""),
            Metadata(ExifInterface.TAG_F_NUMBER, "F NUMBER", ""),
            Metadata(ExifInterface.TAG_GAIN_CONTROL, "GAIN CONTROL", ""),
            Metadata(ExifInterface.TAG_GPS_ALTITUDE, "GPS ALTITUDE", ""),
            Metadata(ExifInterface.TAG_GPS_ALTITUDE_REF, "GPS ALTITUDE REF", ""),
            Metadata(ExifInterface.TAG_GPS_AREA_INFORMATION, "GPS AREA INFORMATION", ""),
            Metadata(ExifInterface.TAG_GPS_DATESTAMP, "GPS DATESTAMP", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_BEARING, "GPS DEST BEARING", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_DISTANCE, "GPS DEST DISTANCE", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, "GPS DEST DISTANCE REF", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_LATITUDE, "GPS DEST LATITUDE", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_LATITUDE_REF, "GPS DEST LATITUDE REF", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_LONGITUDE, "GPS DEST LONGITUDE", ""),
            Metadata(ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, "GPS DEST LONGITUDE REF", ""),
            Metadata(ExifInterface.TAG_GPS_DIFFERENTIAL, "GPS DIFFERENTIAL", ""),
            Metadata(ExifInterface.TAG_GPS_DOP, "GPS DOP", ""),
            Metadata(ExifInterface.TAG_GPS_IMG_DIRECTION, "GPS IMG DIRECTION", ""),
            Metadata(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, "GPS IMG DIRECTION REF", ""),
            Metadata(ExifInterface.TAG_GPS_LATITUDE, "GPS LATITUDE", ""),
            Metadata(ExifInterface.TAG_GPS_LATITUDE_REF, "GPS LATITUDE REF", ""),
            Metadata(ExifInterface.TAG_GPS_LONGITUDE, "GPS LONGITUDE", ""),
            Metadata(ExifInterface.TAG_GPS_LONGITUDE_REF, "GPS LONGITUDE REF", ""),
            Metadata(ExifInterface.TAG_GPS_MAP_DATUM, "GPS AP DATUM", ""),
            Metadata(ExifInterface.TAG_GPS_MEASURE_MODE, "GPS MEASURE MODE", ""),
            Metadata(ExifInterface.TAG_GPS_PROCESSING_METHOD, "GPS PROCESSING METHOD", ""),
            Metadata(ExifInterface.TAG_GPS_SATELLITES, "GPS SATELLITES", ""),
            Metadata(ExifInterface.TAG_GPS_SPEED, "GPS SPEED", ""),
            Metadata(ExifInterface.TAG_GPS_SPEED_REF, "GPS SPEED REF", ""),
            Metadata(ExifInterface.TAG_GPS_STATUS, "GPS STATUS", ""),
            Metadata(ExifInterface.TAG_GPS_TIMESTAMP, "GPS TIMESTAMP", ""),
            Metadata(ExifInterface.TAG_GPS_TRACK, "GPS TRACK", ""),
            Metadata(ExifInterface.TAG_GPS_TRACK_REF, "GPS TRACK REF", ""),
            Metadata(ExifInterface.TAG_GPS_VERSION_ID, "GPS VERSION ID", ""),
            Metadata(ExifInterface.TAG_IMAGE_DESCRIPTION, "IMAGE DESCRIPTION", ""),
            Metadata(ExifInterface.TAG_IMAGE_LENGTH, "IMAGE LENGTH", ""),
            Metadata(ExifInterface.TAG_IMAGE_UNIQUE_ID, "IMAGE UNIQUE ID", ""),
            Metadata(ExifInterface.TAG_IMAGE_WIDTH, "IMAGE WIDTH", ""),
            Metadata(ExifInterface.TAG_INTEROPERABILITY_INDEX, "INTEROPERABILITY INDEX", ""),
            Metadata(ExifInterface.TAG_ISO_SPEED_RATINGS, "ISO SPEED RATINGS", ""),
            Metadata(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, "JPEG INTERCHANGE FORMAT", ""),
            Metadata(
                ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH,
                "JPEG INTERCHANGE FORMAT LENGTH",
                ""
            ),
            Metadata(ExifInterface.TAG_LIGHT_SOURCE, "LIGHT SOURCE", ""),
            Metadata(ExifInterface.TAG_MAKE, "MAKE", ""),
            Metadata(ExifInterface.TAG_MAKER_NOTE, "MAKER NOTE", ""),
            Metadata(ExifInterface.TAG_MAX_APERTURE_VALUE, "MAX APERTURE VALUE", ""),
            Metadata(ExifInterface.TAG_METERING_MODE, "METERING MODE", ""),
            Metadata(ExifInterface.TAG_MODEL, "MODEL", ""),
            Metadata(ExifInterface.TAG_NEW_SUBFILE_TYPE, "NEW SUBFILE TYPE", ""),
            Metadata(ExifInterface.TAG_OECF, "OECF", ""),
            Metadata(ExifInterface.TAG_ORF_ASPECT_FRAME, "ORF ASPECT FRAME", ""),
            Metadata(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, "ORF PREVIEW IMAGE LENGTH", ""),
            Metadata(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, "ORF PREVIEW IMAGE START", ""),
            Metadata(ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, "ORF THUMBNAIL IMAGE", ""),
            Metadata(ExifInterface.TAG_ORIENTATION, "ORIENTATION", ""),
            Metadata(
                ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION,
                "PHOTOMETRIC INTERPRETATION",
                ""
            ),
            Metadata(ExifInterface.TAG_PIXEL_X_DIMENSION, "PIXEL X DIMENSION", ""),
            Metadata(ExifInterface.TAG_PIXEL_Y_DIMENSION, "PIXEL Y DIMENSION", ""),
            Metadata(ExifInterface.TAG_PLANAR_CONFIGURATION, "PLANAR CONFIGURATION", ""),
            Metadata(ExifInterface.TAG_PRIMARY_CHROMATICITIES, "PRIMARY CHROMATICITIES", ""),
            Metadata(ExifInterface.TAG_REFERENCE_BLACK_WHITE, "REFERENCE BLACK WHITE", ""),
            Metadata(ExifInterface.TAG_RELATED_SOUND_FILE, "RELATED SOUND FILE", ""),
            Metadata(ExifInterface.TAG_RESOLUTION_UNIT, "RESOLUTION UNIT", ""),
            Metadata(ExifInterface.TAG_ROWS_PER_STRIP, "ROW PER STRIP", ""),
            Metadata(ExifInterface.TAG_RW2_ISO, "RW2 ISO", ""),
            Metadata(ExifInterface.TAG_RW2_JPG_FROM_RAW, "RW2 JPG FROM RAW", ""),
            Metadata(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, "RW2 SENSOR BOTTOM BORDER", ""),
            Metadata(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, "RW2 SENSOR LEFT BORDER", ""),
            Metadata(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, "RW2 SENSOR RIGHT BORDER", ""),
            Metadata(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, "RW2 SENSOR TOP BORDER", ""),
            Metadata(ExifInterface.TAG_SAMPLES_PER_PIXEL, "SAMPLES PER PIXEL", ""),
            Metadata(ExifInterface.TAG_SATURATION, "SATURATION", ""),
            Metadata(ExifInterface.TAG_SCENE_CAPTURE_TYPE, "SCENE CAPTURE TYPE", ""),
            Metadata(ExifInterface.TAG_SCENE_TYPE, "SCENE TYPE", ""),
            Metadata(ExifInterface.TAG_SENSING_METHOD, "SENSING METHOD", ""),
            Metadata(ExifInterface.TAG_SHARPNESS, "SHARPNESS", ""),
            Metadata(ExifInterface.TAG_SHUTTER_SPEED_VALUE, "SHUTTER SPEED VALUE", ""),
            Metadata(ExifInterface.TAG_SOFTWARE, "SOFTWARE", ""),
            Metadata(
                ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE,
                "SPATIAL FREQUENCY RESPONSE",
                ""
            ),
            Metadata(ExifInterface.TAG_SPECTRAL_SENSITIVITY, "SPECTRAL SENSITIVITY", ""),
            Metadata(ExifInterface.TAG_STRIP_BYTE_COUNTS, "STRIP BYTE COUNTS", ""),
            Metadata(ExifInterface.TAG_STRIP_OFFSETS, "STRIP OFFSETS", ""),
            Metadata(ExifInterface.TAG_SUBFILE_TYPE, "SUBFILE TYPE", ""),
            Metadata(ExifInterface.TAG_SUBJECT_AREA, "SUBJECT AREA", ""),
            Metadata(ExifInterface.TAG_SUBJECT_DISTANCE, "SUBJECT DISTANCE", ""),
            Metadata(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, "SUBJECT DISTANCE RANGE", ""),
            Metadata(ExifInterface.TAG_SUBJECT_LOCATION, "SUBJECT LOCATION", ""),
            Metadata(ExifInterface.TAG_SUBSEC_TIME, "SUBSEC TIME", ""),
            Metadata(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, "SUBSEC TIME DIGITIZED", ""),
            Metadata(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, "SUBSEC TIME ORIGINAL", ""),
            Metadata(ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, "THUMBNAIL IMAGE LENGTH", ""),
            Metadata(ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, "THUMBNAIL IMAGE WIDTH", ""),
            Metadata(ExifInterface.TAG_TRANSFER_FUNCTION, "TRANSFER FUNCTION", ""),
            Metadata(ExifInterface.TAG_USER_COMMENT, "USER_COMMENT", ""),
            Metadata(ExifInterface.TAG_WHITE_BALANCE, "WHITE BALANCE", ""),
            Metadata(ExifInterface.TAG_WHITE_POINT, "WHITE POINT", ""),
            Metadata(ExifInterface.TAG_X_RESOLUTION, "X RESOLUTION", ""),
            Metadata(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, "Y CB CR COEFFICIENTS", ""),
            Metadata(ExifInterface.TAG_Y_CB_CR_POSITIONING, "Y CB CR POSITIONING", ""),
            Metadata(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, "Y CB CR SUB SAMPLING", ""),
            Metadata(ExifInterface.TAG_Y_RESOLUTION, "Y RESOLUTION", "")
        )
    }
}

