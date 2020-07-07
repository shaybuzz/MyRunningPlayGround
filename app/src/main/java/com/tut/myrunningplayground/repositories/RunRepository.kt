package com.tut.myrunningplayground.repositories

import com.tut.myrunningplayground.db.RunDao
import com.tut.myrunningplayground.db.entity.Run
import javax.inject.Inject

class RunRepository @Inject constructor(private val runDao: RunDao) {

    fun getAverageSpeed() = runDao.getAverageSpeed()
    fun getRunsByDistance() = runDao.getRunsByDistance()
    fun getRunsByDate() = runDao.getRunsByDate()
    fun getRunsByDuration() = runDao.getRunsByDuration()
    fun getRunsBySpeed() = runDao.getRunsBySpeed()
    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalDuration() = runDao.getTotalDuration()
    suspend fun delete(run: Run) = runDao.delete(run)
    suspend fun upsert(run: Run) = runDao.upsert(run)

}