//package com.sharifsaleh.architectureexample
//
//import android.content.Context
//import android.util.Log
//
//class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
//
//    override fun doWork(): ListenableWorker.Result {
//        Log.d(TAG, "Performing long running task in scheduled job")
//        // TODO(developer): add long running task here.
//        return ListenableWorker.Result.success()
//    }
//
//    companion object {
//        private val TAG = "MyWorker"
//    }
//}