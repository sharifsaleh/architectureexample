package com.sharifsaleh.architectureexample.business.interactors

import com.sharifsaleh.architectureexample.business.Course
import com.sharifsaleh.architectureexample.business.CourseDataSource
import com.sharifsaleh.architectureexample.business.CourseLocalDataSource
import com.sharifsaleh.architectureexample.framwork.datasource.network.CourseResponse

class CourseInteractors (
    private val courseDataSource: CourseDataSource,
    private val courseLocalDataSource: CourseLocalDataSource
) {

    suspend fun course(): CourseResponse {
        return courseDataSource.course()
    }

    suspend fun getCourseDb(): List<Course> {
        return courseLocalDataSource.getCourses()
    }

    suspend fun insertCourses(courses: List<Course>) {
        courseLocalDataSource.insertCourse(courses)
    }
}


