package net.simplifiedcoding.ui.home

import android.os.Bundle
import android.view.View
import net.simplifiedcoding.R
import net.simplifiedcoding.data.Course
import net.simplifiedcoding.databinding.FragmentHomeBinding
import net.simplifiedcoding.ui.base.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private  val coursesAdapter = CoursesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.recyclerViewCourses.adapter = coursesAdapter
        val courses = listOf(
            Course("", "", "", "", 0, 0, "", "", "Title 1", ""),
            Course("", "", "", "", 0, 0, "", "", "Title 2", ""),
            Course("", "", "", "", 0, 0, "", "", "Title 3", ""),
            Course("", "", "", "", 0, 0, "", "", "Title 4", ""),
            Course("", "", "", "", 0, 0, "", "", "Title 5", ""),
        )
        coursesAdapter.items = courses
    }
}