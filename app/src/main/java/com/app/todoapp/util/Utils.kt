package com.app.todoapp.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

object Utils {

    fun confirmationAlert(context: Context, title: String, message: String, listener: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(context)
        with(builder) {
            create()
            setTitle(title)
            setMessage(message)
            setPositiveButton("OK", listener)
            builder.show()
        }
    }

}