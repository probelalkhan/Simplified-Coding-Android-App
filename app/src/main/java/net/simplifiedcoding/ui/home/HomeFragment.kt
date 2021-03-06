package net.simplifiedcoding.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.simplifiedcoding.R
import net.simplifiedcoding.databinding.FragmentHomeBinding
import net.simplifiedcoding.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getLatestCourses()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val courseAdapter = CoursesAdapter()
        binding.recyclerViewCourses.adapter = courseAdapter

        courseAdapter.recyclerViewItemClickListener = { position, item, view ->
            Toast.makeText(requireContext(), "$item", Toast.LENGTH_SHORT).show()
        }

        viewModel.latestCoursesLiveData.observe(viewLifecycleOwner) { courses ->
            courseAdapter.items = courses
        }

        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            binding.swipeRefreshLayout.isRefreshing = loading
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getLatestCourses(true)
        }
    }
}