package com.sharifsaleh.architectureexample.framwork.datasource.presentation.util

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.sharifsaleh.architectureexample.R


object ErrorToast {

    fun showToast(activity: Activity,text: String,errorToast: Boolean) {
        val inflater: LayoutInflater = activity.layoutInflater
        val layout: View = inflater.inflate(
            R.layout.custom_toast,
            activity.findViewById(R.id.custom_toast_container) as ViewGroup?
        )
        if(errorToast)
            layout.setBackgroundColor(Color.parseColor("#B5DF3C30"))
        else
            layout.setBackgroundColor(Color.parseColor("#88005391"))
        val textView = layout.findViewById<TextView>(R.id.toast_text)
        textView.text = text
        Toast(activity.applicationContext).apply {
            setGravity(Gravity.FILL_HORIZONTAL + Gravity.TOP,0,0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}