package net.simplifiedcoding.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.data.LatestCoursesResponse
import net.simplifiedcoding.data.Resource
import net.simplifiedcoding.data.repositories.CoursesRepository
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val coursesRepository: CoursesRepository
) : ViewModel() {

    val latestCoursesLiveData: LiveData<Resource<LatestCoursesResponse>>
        get() = _latestCoursesLiveData

    private val _latestCoursesLiveData = MutableLiveData<Resource<LatestCoursesResponse>>()

    fun getLatestCourses() = viewModelScope.launch {
        _latestCoursesLiveData.value = Resource.Loading()
        _latestCoursesLiveData.value = coursesRepository.getLatestCourses()
    }

}