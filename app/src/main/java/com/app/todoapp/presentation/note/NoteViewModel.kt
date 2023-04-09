package com.app.todoapp.presentation.note

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.app.todoapp.util.AlarmReceiver
import com.app.todoapp.util.Constants.Channel_Name
import com.app.todoapp.util.Constants.CreateNotif
import com.app.todoapp.util.Constants.Description
import com.app.todoapp.util.Constants.EmptyField
import com.app.todoapp.util.Constants.NoteAdded
import com.app.todoapp.util.Constants.NoteUpdate
import com.app.todoapp.util.formatTime
import com.app.todoapp.util.toast
import com.example.data.utils.Constants
import com.example.domain.entity.NoteInfo
import com.example.domain.note.NotesRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val roomUseCase: NotesRoomUseCase) : ViewModel() {

    private val date = LocalDate.now()
    private val time = LocalTime.now().formatTime()

    private fun addNote(title: String, note: String) {
        viewModelScope.launch {
            val noteInfo =
                NoteInfo(
                    0,
                    title,
                    note,
                    date.toString(),
                    time.toString()
                )
            roomUseCase.addNote(noteInfo)
        }
    }

    private fun updateNote(id: Int, title: String, note: String) {
        viewModelScope.launch {
            val noteInfo = NoteInfo(
                id,
                title,
                note, date.toString(), time.toString()
            )
            roomUseCase.updateNote(noteInfo)
        }
    }

    fun checkNote(argsId: Int, id: Int, title: EditText, note: EditText, fragment: Fragment, context: Context) {
        when {
            id == argsId -> {
                if (title.text.isNullOrBlank() || note.text.isNullOrBlank()
                ) {
                    context.toast(EmptyField)
                } else {
                    addNote(
                        title.text.toString(),
                        note.text.toString()
                    )
                    val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
                    context.toast(NoteAdded)
                    fragment.findNavController().navigate(action)
                }
            }

            else -> {
                if (title.text.isNullOrBlank() || note.text.isNullOrBlank()
                ){
                    context.toast(EmptyField)
                } else {
                    updateNote(
                        argsId,
                        title.text.toString(),
                        note.text.toString()
                    )
                    val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
                    context.toast(NoteUpdate)
                    fragment.findNavController().navigate(action)
                }
            }
        }
    }

    fun createNotification(context: Context) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(Constants.channelId, Channel_Name, importance)
            channel.description = Description
            val notification =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notification.createNotificationChannel(channel)
        }
    }

    fun showDateTimePicker(inputTitle: String, context: Context, fragment: Fragment) {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
            val timePicker = TimePickerDialog(context, { _, selectedHour, selectedMinute ->
                scheduleNotification(
                    inputTitle,
                    selectedYear,
                    selectedMonth,
                    selectedDay,
                    selectedHour,
                    selectedMinute,
                    context,
                    fragment
                )
            }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), true)

            timePicker.show()
        }, year, month, day)

        datePicker.show()
    }

    private fun scheduleNotification(
        inputTitle: String,
        year: Int,
        month: Int,
        day: Int,
        hour: Int,
        minute: Int,
        context: Context,
        fragment: Fragment
    ) {
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.putExtra(Constants.titleExtra, "Reminder: $inputTitle")
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            Constants.notificationId,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = Calendar.getInstance()
        time.set(year, month, day, hour, minute, 0)
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time.timeInMillis, pendingIntent
        )
        val action = NoteFragmentDirections.actionNoteFragmentToListFragment()
        fragment.findNavController().navigate(action)
        context.toast(CreateNotif)
    }
}