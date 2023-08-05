package com.example.precofipeapp.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import com.example.precofipeapp.ModelosActivity

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

        @JvmStatic
        fun show(title: String, message: String, activity: ModelosActivity) {
            val alertDialogBuilder = AlertDialog.Builder(activity);
            alertDialogBuilder.setTitle(title)
            alertDialogBuilder.setMessage(message)
            alertDialogBuilder.setCancelable(false)
            alertDialogBuilder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
            alertDialogBuilder.create().show()
        }
    }
}