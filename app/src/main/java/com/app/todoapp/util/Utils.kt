package com.app.todoapp.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

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

    fun questionAlert(context: Context, title: String, message: String, positive: DialogInterface.OnClickListener, negative: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(context)
        with(builder) {
            create()
            setTitle(title)
            setMessage(message)
            setPositiveButton("OK", positive)
            setNegativeButton("Cancel", negative)
            builder.show()
        }
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    fun showToast(message: String, context: Context) {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
}