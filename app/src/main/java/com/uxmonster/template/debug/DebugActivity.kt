package com.uxmonster.template.debug

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class DebugActivity : AppCompatActivity() {
    /*
    * [Process 1] 앱 실행     : onCreate - onStart - onResume
    * [Process 2] 홈으로 이동  : onPause - onStop
    * [Process 3] 앱 다시 실행 : onRestart - onStart - onResume
    * [Process 4] 백 버튼 클릭 : onPause - onStop - onDestroy
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("${this.javaClass.name}", " onCreate - Activity 생성 / 화면 전환")
    }

    override fun onStart() {
        super.onStart()
        Log.d("${this.javaClass.name}", "onStart - onCreate 호출 직후 / Activity가 정지 상태가 되었다가 활동으로 돌아올 때")
    }

    override fun onResume() {
        super.onResume()
        Log.d("${this.javaClass.name}", "onResume - onStart 호출 직후 / Activity가 일시정지 상태가 되었다가 활동으로 돌아올 때")
    }

    override fun onPause() {
        super.onPause()
        Log.d("${this.javaClass.name}", "onPause - Activity가 일시정지 상태가 될 때 / 화면상에서 완전히 사라질 때 / 현재 화면 위에 작은 팝업창 같은 것을 나타낼 때")
    }

    override fun onStop() {
        super.onStop()
        Log.d("${this.javaClass.name}", "onStop - Activity가 화면에서 완전히 사라질 때")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("${this.javaClass.name}", "onRestart - Activity가 정지 상태가 되었다가 활동으로 돌아올 때 (onStart 호출 전)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("${this.javaClass.name}", "onDestroy - Activity가 완전히 종료된 후, 메모리상에서도 제거될 때")
    }

}