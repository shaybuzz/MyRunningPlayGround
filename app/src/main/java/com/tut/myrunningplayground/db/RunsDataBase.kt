package com.tut.myrunningplayground.db

import android.content.Context
import androidx.room.*
import com.tut.myrunningplayground.db.entity.Run

@Database(entities = [Run::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RunsDataBase : RoomDatabase() {
    abstract fun getRunDao():RunDao

    companion object{
        @Volatile
        private var INSTANCE:RunsDataBase? = null

        fun getInstance(context: Context):RunsDataBase{
            val tmp = INSTANCE
            if(tmp != null) return tmp
            synchronized(this){
                val tmp2  =  INSTANCE
                if(tmp2 == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RunsDataBase::class.java,
                        "run_db"
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }

}