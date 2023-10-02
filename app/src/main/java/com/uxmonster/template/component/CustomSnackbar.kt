package com.uxmonster.template.component

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
import com.google.android.material.snackbar.Snackbar
import com.uxmonster.template.R


// [사용목적] 액티비티의 상태를 표현할 때
class CustomSnackbar {
    companion object {
        fun make(activity: Context, view: View) {

            // [디자인]
            val snack = Snackbar.make(view, "기본 스낵바", Snackbar.LENGTH_SHORT) // 스낵바 생성
            // val snack = Snackbar.make(view, "액션 스낵바 - 액션(setAction) 버튼과 함께라면 사라지지 않도록 함", Snackbar.LENGTH_INDEFINITE)
            val snackView = LayoutInflater.from(activity).inflate(R.layout.custom_snackbar, null) // 스낵바 뷰 생성
            val snackLayout = snack.view as Snackbar.SnackbarLayout // 스낵바 레이아웃 추출 및 뷰 추가
            snackLayout.addView(snackView)
            val snackText = snackLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text) // 스낵바에 있는 내장 텍스트 지우기
            snackText.visibility = View.INVISIBLE
            snackView.run {
                val snackbarText = view.findViewById<TextView>(R.id.custom_snackbar_text)
                snackbarText.text = "HELLO"
            }

            // [액션]
            snack.setAction("Action - 한개만 가능함") {
                Log.d("${this.javaClass.name}", " setAction - 액션을 실행함")
            }

            // [콜백]
            var callback = object : BaseCallback<Snackbar>(){
                override fun onShown(transientBottomBar: Snackbar?) {
                    Log.d("${this.javaClass.name}", " onShown - 스낵바 나타남")
                    super.onShown(transientBottomBar)
                }
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    Log.d("${this.javaClass.name}", " onDismissed - 스낵바 사라짐")
                    super.onDismissed(transientBottomBar, event)
                }
            }

            snack.show()
        }
    }
}