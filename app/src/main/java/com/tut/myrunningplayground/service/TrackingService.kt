package com.tut.myrunningplayground.service

import android.app.NotificationChannel
import android.content.Context
import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.tut.myrunningplayground.utils.Consts.SERVICE_ACTION_PAUSE
import com.tut.myrunningplayground.utils.Consts.SERVICE_ACTION_START_OR_RESUME
import com.tut.myrunningplayground.utils.Consts.SERVICE_ACTION_STOP
import timber.log.Timber

class TrackingService : LifecycleService() {

    companion object{
        fun startResumeService(context: Context){
            val intent = Intent(context, TrackingService::class.java)
            intent.action = SERVICE_ACTION_START_OR_RESUME
            context.startService(intent)
        }

        fun stopService(context: Context){
            val intent = Intent(context, TrackingService::class.java)
            intent.action = SERVICE_ACTION_STOP
            context.startService(intent)
        }

        fun pauseService(context: Context){
            val intent = Intent(context, TrackingService::class.java)
            intent.action = SERVICE_ACTION_PAUSE
            context.startService(intent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                SERVICE_ACTION_START_OR_RESUME -> {
                    Timber.d("##start")
                }
                SERVICE_ACTION_PAUSE -> {
                    Timber.d("##pause")
                }
                SERVICE_ACTION_STOP -> {
                    Timber.d("##stop")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    fun createNotificationChanel(){
    }
}