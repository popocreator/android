package com.uxmonster.template

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.uxmonster.template.debug.DebugActivity
import com.uxmonster.template.navigation.NavigationController
import com.uxmonster.template.permission.PermissionController

class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionController.checkPermissions(this)
        PermissionController.requestPermissions(this)

        NavigationController.moveFromMainActivityToSomeActivity(this)

        getDataByActivity1.launch(Intent())
        getDataByActivity2.launch(Intent())
        getDataByActivity3.launch(Intent())
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionController.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private val getDataByActivity1 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        activity1ResultCallback(result)
    }
    private fun activity1ResultCallback(result: ActivityResult) {
        Log.d("${this.javaClass.name}", "onActivityResult - ${result.resultCode}")
        if (result.resultCode == RESULT_OK) {
            // 백 버튼으로 돌아오는 경우를 제외함
        }
    }

    private val getDataByActivity2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        activity2ResultCallback(result)
    }
    private fun activity2ResultCallback(result: ActivityResult) {
        Log.d("${this.javaClass.name}", "onActivityResult - ${result.resultCode}")
        if (result.resultCode == RESULT_OK) {
            // 백 버튼으로 돌아오는 경우를 제외함
        }
    }

    private val getDataByActivity3 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        activity3ResultCallback(result)
    }
    private fun activity3ResultCallback(result: ActivityResult) {
        Log.d("${this.javaClass.name}", "onActivityResult - ${result.resultCode}")
        if (result.resultCode == RESULT_OK) {
            // 백 버튼으로 돌아오는 경우를 제외함
        }
    }

}