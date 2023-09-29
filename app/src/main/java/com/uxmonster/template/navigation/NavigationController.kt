package com.uxmonster.template.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.uxmonster.template.MainActivity

class NavigationController {
    companion object {
        private var activity: AppCompatActivity? = null

        private fun moveFrom(context: AppCompatActivity): Companion {
            activity = context
            return this
        }

        private fun <T> to(targetActivity: Class<T>) {
            val intent = Intent(activity, targetActivity)
            activity?.startActivity(intent)
        }

        fun moveFromMainActivityToSomeActivity(mainActivity: AppCompatActivity) {
            moveFrom(mainActivity).to(MainActivity::class.java)
        }
    }
}