package com.tut.myrunningplayground.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tut.myrunningplayground.db.entity.Run

@Dao
interface RunDao {

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getRunsByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getRunsByDistance(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY durationMilli DESC")
    fun getRunsByDuration(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY speedAverageKmPerH DESC")
    fun getRunsBySpeed(): LiveData<List<Run>>

    @Query("SELECT AVG(speedAverageKmPerH) FROM running_table")
    fun getAverageSpeed(): LiveData<Float>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(durationMilli) FROM running_table")
    fun getTotalDuration(): LiveData<Long>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(run: Run)

    @Delete
    suspend fun delete(run: Run)


}