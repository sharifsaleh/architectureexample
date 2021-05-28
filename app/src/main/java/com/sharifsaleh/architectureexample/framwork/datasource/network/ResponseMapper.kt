package com.sharifsaleh.architectureexample.framwork.datasource.network

import com.sharifsaleh.architectureexample.business.Course

object ResponseMapper {

    private fun getCourse(courseBody: CourseResponseBody): Course {
        return Course(id = courseBody.id,
            enTitle = courseBody.enTitle,
            arTitle = courseBody.arTitle,
            enDec = courseBody.enDec,
            arDec = courseBody.arDec,
            lightImage = courseBody.lightImage,
            darkImage = courseBody.darkImage,
            spPrice = courseBody.spPrice,
            usdPrice = courseBody.usdPrice,
            teachers = courseBody.teachers,
            userState = courseBody.userState,
            rate = courseBody.rate)

    }

    fun getCourseMapper(course: List<CourseResponseBody>?): List<Course> {
        val y = course?.map { course -> getCourse(course)} ?: listOf()
        return y
    }

}