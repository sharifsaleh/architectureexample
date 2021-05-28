//package com.sharifsaleh.architectureexample.framwork.datasource.presentation
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.sharifsaleh.architectureexample.R
//import com.sharifsaleh.architectureexample.business.CoursesSealed
//import com.sharifsaleh.architectureexample.framwork.datasource.presentation.util.Checker
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.android.synthetic.main.activity_main.*
//
//
//@AndroidEntryPoint
//class CourseFragment : Fragment() {
//
//    private val courseViewModel: CourseViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.activity_main, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        attachData()
//    }
//
//    private fun attachData() {
//        if(Checker.isConnected(requireContext()))
//            attachAdapters()
//        else
//            handleNoConnection()
//    }
//
//    private fun attachAdapters() {
//        setCoursesAdapter()
//    }
//
//    private fun handleNoConnection() {
////        findNavController().navigate(R.id.action_homeContainerFragment_to_noConnectionFragment)
//    }
//
//    private fun setCoursesAdapter() {
//        val courseAdapter = CourseAdapter(this)
//        course_recycler_view_course.adapter = courseAdapter
//        course_recycler_view_course.layoutManager = LinearLayoutManager(requireContext())
////        course_recycler_view_course.showShimmer()
//        courseViewModel.getCourses().observe(requireActivity(), {
//            when (it) {
//                is CoursesSealed.Success -> {
//                    courseAdapter.bindData(it.data)
////                    course_recycler_view_course.hideShimmer()
//                }
//                is CoursesSealed.Failure -> {
////                    ErrorToast.showToast(requireActivity(), it.code, false)
//                }
//            }
//        })
//
//    }
//}