package com.uxmonster.template.navigation

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.uxmonster.template.MainActivity
import com.uxmonster.template.model.User

class NavigationController {
    companion object {
        private var activity: AppCompatActivity? = null

        private fun moveFrom(context: AppCompatActivity): Companion {
            activity = context
            return this
        }

        private fun to(targetActivityIntent: Intent) {
            activity?.startActivity(targetActivityIntent)
        }

        fun moveFromMainActivityToSomeActivity(mainActivity: AppCompatActivity) {
            // [데이터 전달]
            val result = Intent()
            result.putExtra("data1", 100)
            result.putExtra("data2", 11.11)
            result.putExtra("data3", true)
            result.putExtra("data4", "문자열")
            result.putExtra("object1", User())
            mainActivity.setResult(RESULT_OK, result) // RESULT_OK는 백버튼을 눌러서 돌아오는 상황을 구분하기 위해서 넣어줍니다.

            // [데이터 불러오기]
            result.getIntExtra("data1", 0)
            result.getDoubleExtra("data2", 0.0)
            result.getBooleanExtra("data3", false)
            result.getStringExtra("data4")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                result.getParcelableExtra("object1", User::class.java)
            } else {
                result.getParcelableExtra<User>(Intent.EXTRA_STREAM)
            }

            // [화면 이동]
            val mainActivityIntent = Intent(mainActivity, MainActivity::class.java)
            moveFrom(mainActivity).to(mainActivityIntent)
        }

        // [지도] 지도 실행
        fun moveToMap(context: AppCompatActivity) {
            val uri = Uri.parse("geo:37.243243,131.861601")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }

        // [웹브라우저] 웹브라우저 실행
        fun moveToWebBrowser(context: AppCompatActivity) {
            val uri = Uri.parse("https://developer.android.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }

        // [다이얼] 전화번호 입력화면
        fun moveToDial(context: AppCompatActivity) {
            val uri = Uri.parse("tel:01000000000")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            context.startActivity(intent)
        }

        // [콜] 전화 걸기 - android.permission.CALL_PHONE 권한 필요
        fun moveToCall(context: AppCompatActivity) {
            val uri = Uri.parse("tel:01000000000")
            val intent = Intent(Intent.ACTION_CALL, uri)
            context.startActivity(intent)
        }

    }
}