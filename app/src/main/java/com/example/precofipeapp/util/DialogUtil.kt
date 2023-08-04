package com.example.precofipeapp.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface

class DialogUtil {
    companion object {
        fun show(titleText: String, messageText: String, target: Activity) : Unit {

            var alertDialogBuilder = AlertDialog.Builder(target)
            alertDialogBuilder.setTitle(titleText)
            alertDialogBuilder.setMessage(messageText)
            alertDialogBuilder.setCancelable(false)
            alertDialogBuilder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
            alertDialogBuilder.create().show()
        }
    }
}