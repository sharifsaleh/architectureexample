package com.sharifsaleh.architectureexample.framwork.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sharifsaleh.architectureexample.business.Course
import com.sharifsaleh.architectureexample.framwork.datasource.converter.CourseConverter
import com.sharifsaleh.architectureexample.framwork.datasource.dao.CourseDao
import com.sharifsaleh.architectureexample.framwork.datasource.entity.CourseEntity


@Database(
    entities = [CourseEntity::class], version = 1
)
//@TypeConverters(CourseConverter::class)
abstract class CourseDataBase : RoomDatabase() {
    abstract fun courseDao(): CourseDao


}