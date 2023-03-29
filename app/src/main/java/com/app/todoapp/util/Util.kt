package com.app.todoapp.util

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

//Formats local time to HH:MM
fun LocalTime.formatTime(formatStyle: FormatStyle = FormatStyle.SHORT): LocalTime = LocalTime.parse(this.format(
    DateTimeFormatter.ofLocalizedTime(formatStyle)),DateTimeFormatter.ofLocalizedTime(formatStyle))