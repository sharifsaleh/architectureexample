package com.sharifsaleh.architectureexample.framwork.datasource.mapper

import com.sharifsaleh.architectureexample.business.Course
import com.sharifsaleh.architectureexample.framwork.datasource.entity.CourseEntity

object CourseMapper {

    private fun getCourse(courseEntity: CourseEntity) : Course {
        return Course (
            id = courseEntity.id,
            enTitle = courseEntity.enTitle,
            arTitle = courseEntity.arTitle,
            enDec = courseEntity.enDec,
            arDec = courseEntity.arDec,
            lightImage = courseEntity.lightImage,
            darkImage = courseEntity.darkImage,
            spPrice = courseEntity.spPrice,
            usdPrice = courseEntity.usdPrice,
            teachers = listOf(), //courseEntity.teachers,
            userState = courseEntity.userState,
            rate = courseEntity.rate
        )
    }

    fun getCourseEntity(course: Course): CourseEntity {
        return CourseEntity(
            id = course.id,
            enTitle = course.enTitle,
            arTitle = course.arTitle,
            enDec = course.enDec,
            arDec = course.arDec,
            lightImage = course.lightImage,
            darkImage = course.darkImage,
            spPrice = course.spPrice,
            usdPrice = course.usdPrice,
//            teachers = course.teachers,
            userState = course.userState,
            rate = course.rate
        )
    }

    fun getCourseList(courseEntity: List<CourseEntity>): List<Course> {
        return courseEntity.map { course -> getCourse(course) }
    }

    fun getCourseEntityList(courses: List<Course>): List<CourseEntity> {
        return courses.map { course -> getCourseEntity(course) }
    }
}