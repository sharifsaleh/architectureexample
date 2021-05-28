package com.sharifsaleh.architectureexample.business

import com.sharifsaleh.architectureexample.framwork.datasource.entity.Teacher

sealed class CoursesSealed {
    data class Success(val data: List<Course>) : CoursesSealed()
    data class Failure(val code: String) : CoursesSealed()
}

data class Course(
    val id: String,
    val enTitle: String,
    val arTitle: String,
    val enDec: String,
    val arDec: String,
    val spPrice: Int,
    val usdPrice: Int,
    val lightImage: String,
    val darkImage: String,
    val rate: Int,
    val teachers: List<Teacher>?,
    val userState: String
)