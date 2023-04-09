package com.app.todoapp.util

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun LocalTime.formatTime(formatStyle: FormatStyle = FormatStyle.SHORT): LocalTime = LocalTime.parse(
    this.format(
        DateTimeFormatter.ofLocalizedTime(formatStyle)
    ), DateTimeFormatter.ofLocalizedTime(formatStyle)
)

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Context.alert(
    title: String,
    message: String,
    buttonPositive: String,
    onClickPositive: () -> Unit,
    buttonNegative: String,
    onClickNegative: () -> Unit
) {
    val builder = AlertDialog.Builder(this)
    with(builder) {
        create()
        setTitle(title)
        setMessage(message)
        setPositiveButton(buttonPositive) { dialog, which ->
            onClickPositive.invoke()
        }
        setNegativeButton(buttonNegative) { dialog, which ->
            onClickNegative.invoke()
            dialog.dismiss()
        }
        builder.show()
    }
}