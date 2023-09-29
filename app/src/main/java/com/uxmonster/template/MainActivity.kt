package com.uxmonster.template

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.uxmonster.template.debug.DebugActivity
import com.uxmonster.template.navigation.NavigationController
import com.uxmonster.template.permission.PermissionController

class MainActivity : DebugActivity() {

    private val getContent = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        activityResultCallback(uri)
    }

    private fun activityResultCallback(uri: Uri?) {
        Log.d("${this.javaClass.name}", "onActivityResult - ${uri.toString()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionController.checkPermissions(this)
        PermissionController.requestPermissions(this)

//        NavigationController.moveFromMainActivityToSomeActivity(this)

        getContent.launch(null)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionController.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}