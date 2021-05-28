package com.sharifsaleh.architectureexample.di

import android.content.Context
import androidx.room.Room
import com.sharifsaleh.architectureexample.framwork.datasource.converter.CourseConverter
import com.sharifsaleh.architectureexample.business.CourseLocalDataSource
import com.sharifsaleh.architectureexample.framwork.datasource.dao.CourseDao
import com.sharifsaleh.architectureexample.framwork.datasource.database.CourseDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {


    @Singleton
    @Provides
    fun provideCourseDatabase(
        @ApplicationContext appContext: Context
    ): CourseDataBase {
        return Room.databaseBuilder(
            appContext,
            CourseDataBase::class.java,
            "course_data_base"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCourseDao(courseDataBase: CourseDataBase): CourseDao {
        return courseDataBase.courseDao()
    }

    @Singleton
    @Provides
    fun provideCourseDataSource(courseDao: CourseDao): CourseLocalDataSource {
        return CourseLocalDataSource(courseDao)
    }



}