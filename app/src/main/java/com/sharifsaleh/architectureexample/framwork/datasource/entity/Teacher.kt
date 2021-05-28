package com.sharifsaleh.architectureexample.framwork.datasource.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val fistName: String,
    val lasName: String
)