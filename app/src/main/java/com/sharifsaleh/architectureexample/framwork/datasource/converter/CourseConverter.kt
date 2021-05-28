package com.sharifsaleh.architectureexample.framwork.datasource.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sharifsaleh.architectureexample.business.Course


@ProvidedTypeConverter
class CourseConverter {

//    @TypeConverter
//    fun fromCourseJson(list: List<Course>): String {
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    fun toCourseList(value: String): List<Course> {
//        val notesType = object : TypeToken<List<Course>>() {}.type
//        return Gson().fromJson(value, notesType)
//    }

//    @TypeConverter
//    fun toListOfStrings(flatStringList: String): List<String> {
//        return flatStringList.split(",")
//    }
//    @TypeConverter
//    fun fromListOfStrings(listOfString: List<String>): String {
//        return listOfString.joinToString(",")
//    }
}