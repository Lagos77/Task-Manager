package com.app.todoapp.util

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.app.todoapp.R
import com.example.data.utils.Constants.channelId
import com.example.data.utils.Constants.notificationId
import com.example.data.utils.Constants.titleExtra

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(intent.getStringExtra(titleExtra))
            .setSmallIcon(R.drawable.icon_android)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(notificationId, notification)
    }
}