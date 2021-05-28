package com.sharifsaleh.architectureexample.framwork.datasource.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey(autoGenerate = false)
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
//    val teachers: List<Teacher>?,
    val userState: String
)