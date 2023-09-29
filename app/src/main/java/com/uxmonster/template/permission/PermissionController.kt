package com.uxmonster.template.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class PermissionController {

    companion object {
        private val permissions = arrayOf(
            Manifest.permission.INTERNET
        )

        private var deniedPermissions = ArrayList<String>()

        fun checkPermissions(context: AppCompatActivity) {
            for (permission in permissions) {
                val check = context.checkCallingOrSelfPermission(permission)
                if (check == PackageManager.PERMISSION_DENIED) {
                    deniedPermissions.add(permission)
                }
            }
        }

        fun requestPermissions(context: AppCompatActivity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.requestPermissions(this.permissions,0)
            }
        }

        fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            for (idx in grantResults.indices) {
                if (grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("permission", "${permissions[idx]} 허용 \n")
                } else if (grantResults[idx] == PackageManager.PERMISSION_DENIED) {
                    Log.d("permission", "${permissions[idx]} 거부 \n")
                }
            }
        }
    }

}
