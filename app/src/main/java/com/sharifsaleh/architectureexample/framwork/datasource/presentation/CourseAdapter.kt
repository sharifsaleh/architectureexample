package com.sharifsaleh.architectureexample.framwork.datasource.presentation

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sharifsaleh.architectureexample.R
import com.sharifsaleh.architectureexample.business.Course
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_item_layout.view.*

class CourseAdapter(private val activity: Activity): RecyclerView.Adapter<CourseViewHolder>() {

    private var items = listOf<Course>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
//        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item_layout, parent, false)
        return CourseViewHolder(view, activity)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
//        TODO("Not yet implemented")
        holder.bindData(items[position])
    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return items.size
    }

    fun bindData(items: List<Course>) {
        this.items = items
        this.notifyDataSetChanged()
    }
}

class CourseViewHolder(val view: View, private val activity: Activity): RecyclerView.ViewHolder(view) {

    fun bindData(course: Course) {
        Picasso.get().load(course.darkImage).into(view.course_image)
        Picasso.get().load(course.lightImage).into(view.course_lock)
        view.course_level.text = course.enDec
        view.course_title.text = course.enTitle
        view.course_price.text = course.spPrice.toString()
    }
}