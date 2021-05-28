package com.sharifsaleh.architectureexample.framwork.datasource.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.sharifsaleh.architectureexample.business.CoursesSealed
import com.sharifsaleh.architectureexample.business.interactors.CourseInteractors
import com.sharifsaleh.architectureexample.framwork.datasource.network.ResponseMapper.getCourseMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(private val courseInteractors: CourseInteractors) :
    ViewModel() {

    @SuppressLint("CheckResult")
    fun getCourses(): MutableLiveData<CoursesSealed> {
        val mutableLiveData = MutableLiveData<CoursesSealed>()
        viewModelScope.launch {

//            val coursesResponse = courseInteractors.course()
//            val courses = getCourseMapper(coursesResponse.result!!.course)
//            mutableLiveData.postValue(CoursesSealed.Success(courses))

            try {
                val coursesResponse = courseInteractors.course()
                val courses = getCourseMapper(coursesResponse.result!!.course)
                mutableLiveData.postValue(CoursesSealed.Success(courses))
                courseInteractors.insertCourses(courses)
            } catch (e: HttpException) {
                val dbCourses = courseInteractors.getCourseDb()
                mutableLiveData.postValue(CoursesSealed.Success(dbCourses))
//                mutableLiveData.postValue(CoursesSealed.Failure(httpToError(e).status))
            } catch (e: IOException) {
                mutableLiveData.postValue(CoursesSealed.Failure("400"))
                val dbCourses = courseInteractors.getCourseDb()
                mutableLiveData.postValue(CoursesSealed.Success(dbCourses))
            }
        }
        return mutableLiveData
    }
}