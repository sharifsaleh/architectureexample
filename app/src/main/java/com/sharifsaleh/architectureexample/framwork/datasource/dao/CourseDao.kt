package com.sharifsaleh.architectureexample.framwork.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sharifsaleh.architectureexample.framwork.datasource.entity.CourseEntity


@Dao
interface CourseDao {

    //Courses functions
    @Query("SELECT * FROM course")
    suspend fun getCourses(): List<CourseEntity>
    // Insert Courses
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: CourseEntity)
    // Delete courses
    @Query("DELETE FROM course")
    suspend fun deleteCourses()
}