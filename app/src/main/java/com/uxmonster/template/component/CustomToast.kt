package com.uxmonster.template.component

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.uxmonster.template.R

class CustomToast {
    companion object {
        fun show(context: Context, message: String) {
            val toastView = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
            toastView.run {
                val textView = this.findViewById<TextView>(R.id.custom_toast_text)
                textView.text = "HELLO"
            }

            val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast.view = toastView

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val callback = object : Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                        val textView = toastView.findViewById<TextView>(R.id.custom_toast_text)
                        textView.text = "onToastHidden"
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        val textView = toastView.findViewById<TextView>(R.id.custom_toast_text)
                        textView.text = "onToastShown"
                    }
                }
                toast.addCallback(callback)
            }

            toast.show()
        }
    }
}