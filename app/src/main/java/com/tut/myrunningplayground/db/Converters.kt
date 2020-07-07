package com.tut.myrunningplayground.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream


class Converters {
    companion object {
        @JvmStatic
        @TypeConverter
        fun fromInstant(bitmap: Bitmap): String {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
            return Base64.encodeToString(byteArray, Base64.DEFAULT)
        }

        @JvmStatic
        @TypeConverter
        fun fromInstant(strBase64: String): Bitmap {
            val byteArray = Base64.decode(strBase64, Base64.DEFAULT)
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        }


    }

}