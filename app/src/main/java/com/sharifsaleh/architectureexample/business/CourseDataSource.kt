package com.sharifsaleh.architectureexample.business

import com.sharifsaleh.architectureexample.framwork.datasource.network.CourseApi
import com.sharifsaleh.architectureexample.framwork.datasource.network.CourseResponse

class CourseDataSource(private val courseApi: CourseApi) {

    suspend fun course(): CourseResponse {
        return courseApi.getCourses()
    }
}