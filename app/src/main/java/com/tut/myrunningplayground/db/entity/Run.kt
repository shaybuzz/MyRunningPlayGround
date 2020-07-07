package com.tut.myrunningplayground.db.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.tut.myrunningplayground.db.Converters

@Entity(tableName = "running_table")
data class Run(
    var image: Bitmap? = null,
    var timestamp: Long = 0,
    var durationMilli: Long = 0,
    var caloriesBurned: Int = 0,
    var distanceInMeters: Int = 0,
    var speedAverageKmPerH: Float = 0f
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}