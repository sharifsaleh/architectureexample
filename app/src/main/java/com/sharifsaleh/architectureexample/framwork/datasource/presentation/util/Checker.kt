package com.sharifsaleh.architectureexample.framwork.datasource.presentation.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.text.format.DateUtils.isToday
import android.util.Patterns
import java.util.*

object Checker{

    fun isConnected(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

}