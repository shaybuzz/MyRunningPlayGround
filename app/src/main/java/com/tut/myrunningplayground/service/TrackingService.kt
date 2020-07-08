package com.tut.myrunningplayground.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.model.LatLng
import com.tut.myrunningplayground.R
import com.tut.myrunningplayground.utils.Consts.ACTION_SHOW_TRACKING_FRAGMENT
import com.tut.myrunningplayground.utils.Consts.CHANNEL_ID
import com.tut.myrunningplayground.utils.Consts.ONGOING_NOTIFICATION_ID
import com.tut.myrunningplayground.utils.Consts.SERVICE_ACTION_PAUSE
import com.tut.myrunningplayground.utils.Consts.SERVICE_ACTION_START_OR_RESUME
import com.tut.myrunningplayground.utils.Consts.SERVICE_ACTION_STOP
import com.tut.myrunningplayground.view.RunsActivity
import timber.log.Timber

typealias PathPoints = MutableList<LatLng>
typealias Pathes = MutableList<PathPoints>

class TrackingService : LifecycleService() {

    companion object {
        fun startResumeService(context: Context) {
            val intent = Intent(context, TrackingService::class.java)
            intent.action = SERVICE_ACTION_START_OR_RESUME
            context.startService(intent)
        }

        fun stopService(context: Context) {
            val intent = Intent(context, TrackingService::class.java)
            intent.action = SERVICE_ACTION_STOP
            context.startService(intent)
        }

        fun pauseService(context: Context) {
            val intent = Intent(context, TrackingService::class.java)
            intent.action = SERVICE_ACTION_PAUSE
            context.startService(intent)
        }

        var isTracking = MutableLiveData<Boolean>()

        //list of path (each new path is created each time the user restart the tracking)
        val trackingPathes = MutableLiveData<Pathes>()
    }

    private fun initPostData() {
        isTracking.postValue(false)
        trackingPathes.postValue(mutableListOf())
    }

    private var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                SERVICE_ACTION_START_OR_RESUME -> {
                    if (isFirstRun) {
                        Timber.d("###start service")
                        isFirstRun = false
                        startForegroundService()
                    } else {
                        Timber.d("###resume service")
                    }
                    isTracking.value = true
                    Timber.d("##start")
                }
                SERVICE_ACTION_PAUSE -> {
                    isTracking.value = false
                    Timber.d("##pause")
                }
                SERVICE_ACTION_STOP -> {
                    isTracking.value = false
                    stopService()
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    fun stopService() {
        stopForeground(true)
        stopSelf()
    }

    private fun getRunPendingIntent(): PendingIntent {
        val intent = Intent(this, RunsActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        }
        return PendingIntent.getActivity(this, 0, intent, FLAG_UPDATE_CURRENT)
    }

    fun startForegroundService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChanel()
        }

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setSmallIcon(R.drawable.ic_baseline_directions_run_24)
            .setAutoCancel(false)
            .setOngoing(true)
            .setContentIntent(getRunPendingIntent())
            .build()

        startForeground(ONGOING_NOTIFICATION_ID, notification)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChanel() {
        // Create the NotificationChannel
        val name = getString(R.string.channel_name)
        val descriptionText = getString(R.string.channel_description)
        val mChannel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW)
        mChannel.description = descriptionText
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }
}