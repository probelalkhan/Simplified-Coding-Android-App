package net.simplifiedcoding.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import net.simplifiedcoding.R
import net.simplifiedcoding.data.network.RetrofitClient
import net.simplifiedcoding.data.network.SimplifiedCodingApi
import net.simplifiedcoding.data.repositories.CoursesRepository
import net.simplifiedcoding.databinding.FragmentHomeBinding
import net.simplifiedcoding.ui.base.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val coursesAdapter = CoursesAdapter()

    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //will not work
        val retrofit = RetrofitClient()
        val api = retrofit.buildApi(SimplifiedCodingApi::class.java)
        val repository = CoursesRepository(api)
        viewModel = ViewModelProvider(this, HomeFragmentViewModelFactory(repository)).get(HomeFragmentViewModel::class.java)
        viewModel.getLatestCourses()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.recyclerViewCourses.adapter = coursesAdapter

        coursesAdapter.recyclerViewItemClickListener = { position, item, view ->
            Toast.makeText(requireContext(), "$item", Toast.LENGTH_SHORT).show()
        }

        viewModel.latestCoursesLiveData.observe(viewLifecycleOwner) {
            coursesAdapter.items = it.courses
        }
    }
}