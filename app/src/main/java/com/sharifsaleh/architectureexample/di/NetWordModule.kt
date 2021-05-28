package com.sharifsaleh.architectureexample.di

import com.google.gson.GsonBuilder
import com.sharifsaleh.architectureexample.business.CourseDataSource
import com.sharifsaleh.architectureexample.business.interactors.CourseInteractors
import com.sharifsaleh.architectureexample.business.CourseLocalDataSource
import com.sharifsaleh.architectureexample.framwork.datasource.network.CourseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWordModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://sky-application.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideCourseApi(
        retrofit: Retrofit
    ): CourseApi {
        return retrofit.create(CourseApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMyCoursesDataSource(
        courseApi: CourseApi
    ): CourseDataSource {
        return CourseDataSource(courseApi)
    }

    @Provides
    @Singleton
    fun provideMyCoursesInteractors(
        courseDataSource: CourseDataSource,
        courseLocalDataSource: CourseLocalDataSource
    ): CourseInteractors {
        return CourseInteractors(courseDataSource, courseLocalDataSource)
    }

}