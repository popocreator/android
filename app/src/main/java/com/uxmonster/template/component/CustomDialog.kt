package com.uxmonster.template.component

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import android.widget.TextView
import com.uxmonster.template.R
import java.util.Calendar

class CustomDialog {
    companion object {
        fun showDefault(context: Context) {
            // [Default]
            val builder = AlertDialog.Builder(context)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그 입니다.")
            builder.setIcon(R.mipmap.ic_launcher)

            // [Custom]
            val customView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
            builder.setView(customView)

            // [Action]
            builder.setPositiveButton("Positive") { dialogInteface, i ->
                customView.run {
                    val textView = customView.findViewById<TextView>(R.id.custom_dialog_text)
                    textView.text = "Click Positive"
                }
            }
            builder.setPositiveButton("Neutral") { dialogInteface, i ->
                customView.run {
                    val textView = customView.findViewById<TextView>(R.id.custom_dialog_text)
                    textView.text = "Click Neutral"
                }
            }
            builder.setPositiveButton("Negative") { dialogInteface, i ->
                customView.run {
                    val textView = customView.findViewById<TextView>(R.id.custom_dialog_text)
                    textView.text = "Click Negative"
                }
            }

            builder.show()
        }

        fun showDatePicker(context: Context) {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener =
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    val textView = datePicker.findViewById<TextView>(R.id.custom_dialog_text)
                    textView.text = "OnDateSetListener = ${year}/${month+1}/${dayOfMonth}"
                }

            val picker = DatePickerDialog(context, listener, year, month, day)
            picker.show()
        }

        fun showTimePicker(context: Context) {
            val calendar = Calendar.getInstance()

            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener =
                TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->
                    val textView = timePicker.findViewById<TextView>(R.id.custom_dialog_text)
                    textView.text = "OnDateSetListener - ${hour}:${minute}"
                }

            val picker = TimePickerDialog(context, listener, hour, minute, true)
            picker.show()
        }

    }
}