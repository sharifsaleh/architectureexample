package com.sharifsaleh.architectureexample.framwork.datasource.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface CourseApi {

     @GET("home/course/isfeature")
     suspend fun getCourses() : CourseResponse

}