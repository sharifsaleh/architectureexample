package com.sharifsaleh.architectureexample.framwork.datasource.network

import com.google.gson.annotations.SerializedName
import com.sharifsaleh.architectureexample.framwork.datasource.entity.Teacher

data class CourseResponse (
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: Error?,
    @SerializedName("result")
    val result: CoursesResult?
    )

data class CoursesResult(
    @SerializedName("courses")
    val course: List<CourseResponseBody>
)

data class CourseResponseBody(
    @SerializedName("_id")
    val id: String,
    @SerializedName("title_en")
    val enTitle: String,
    @SerializedName("title_ar")
    val arTitle: String,
    @SerializedName("description_en")
    val enDec: String,
    @SerializedName("description_ar")
    val arDec: String,
    @SerializedName("image_dark_url")
    val darkImage: String,
    @SerializedName("image_light_url")
    val lightImage: String,
    @SerializedName("price_usd")
    val usdPrice: Int,
    @SerializedName("price_sp")
    val spPrice: Int,
    @SerializedName("rating")
    val rate: Int,
    @SerializedName("course_teachers")
    val teachers: List<Teacher>,
    @SerializedName("user_status")
    val userState: String,
)