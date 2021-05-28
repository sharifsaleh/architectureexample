package com.sharifsaleh.architectureexample.business

import com.sharifsaleh.architectureexample.framwork.datasource.dao.CourseDao
import com.sharifsaleh.architectureexample.framwork.datasource.mapper.CourseMapper.getCourseEntity
import com.sharifsaleh.architectureexample.framwork.datasource.mapper.CourseMapper.getCourseList

class CourseLocalDataSource(private val courseDao: CourseDao) {

    //Course functions
    suspend fun getCourses(): List<Course> {
        return getCourseList(courseDao.getCourses())
    }

    suspend fun insertCourse(courses: List<Course>) {
        courseDao.deleteCourses()
        courses.forEach { course -> courseDao.insertCourse(getCourseEntity(course)) }
    }
}