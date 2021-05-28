package com.sharifsaleh.architectureexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sharifsaleh.architectureexample.business.Course
import com.sharifsaleh.architectureexample.business.CoursesSealed
import com.sharifsaleh.architectureexample.framwork.datasource.presentation.CourseAdapter
import com.sharifsaleh.architectureexample.framwork.datasource.presentation.CourseViewModel
import com.sharifsaleh.architectureexample.framwork.datasource.presentation.CourseViewModel_Factory.newInstance
import com.sharifsaleh.architectureexample.framwork.datasource.presentation.util.ErrorToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

//    lateinit var  adapter: CourseAdapter
//    lateinit var recyclerView: RecyclerView
    lateinit var courseAdapter: CourseAdapter

    private val courseViewModel: CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val courseAdapter = CourseAdapter(this)
//        course_recycler_view_course.adapter = courseAdapter
//        course_recycler_view_course.layoutManager = LinearLayoutManager(this)

//        recyclerView = findViewById<RecyclerView>(R.id.course_recycler_view_course)
//        adapter = CourseAdapter(this)
//        recyclerView?.adapter = adapter

//        subscribeToModel()

//        // Create the observer which updates the UI.
//        val nameObserver = Observer<String> { newName ->
//            // Update the UI, in this case, a TextView.
//            nameTextView.text = newName
//        }

        val courseAdapter = CourseAdapter(this)
        course_recycler_view_course.adapter = courseAdapter
        course_recycler_view_course.layoutManager = LinearLayoutManager(this)
//        course_recycler_view_course.showShimmer()

        courseViewModel.getCourses().observe( this, Observer { it ->
                when (it) {
                    is CoursesSealed.Success -> {
                        val courses = mutableListOf<Course>()
                        courses.addAll(it.data)
                        courseAdapter.bindData(it.data)
                    }
                    is CoursesSealed.Failure -> {
                        ErrorToast.showToast(this, it.code, false)
                    }
                }
        })

    }

    override fun onBackPressed() {

    }

}