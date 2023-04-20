package com.app.todoapp.util

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.app.todoapp.R
import com.example.data.utils.NotificationConstants.channelId
import com.example.data.utils.NotificationConstants.notificationGroup
import com.example.data.utils.NotificationConstants.notificationId
import com.example.data.utils.NotificationConstants.titleExtra

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.icon_android)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setGroup(notificationGroup)
            .build()

        notificationId?.let { manager.notify(it, notification) }

        val summaryNotification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.icon_android)
            .setContentTitle("${intent.getStringExtra(titleExtra)}")
            .setGroup(notificationGroup)
            .setGroupSummary(true)
            .build()

        notificationId?.let { manager.notify(it, summaryNotification) }
    }
}