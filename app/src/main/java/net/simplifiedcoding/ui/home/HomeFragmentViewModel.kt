package net.simplifiedcoding.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.data.Course
import net.simplifiedcoding.data.LatestCoursesResponse
import net.simplifiedcoding.data.Resource
import net.simplifiedcoding.data.db.SimplifiedCodingDatabase
import net.simplifiedcoding.data.repositories.CoursesRepository
import net.simplifiedcoding.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val coursesRepository: CoursesRepository,
    private val db: SimplifiedCodingDatabase
) : BaseViewModel() {

    val latestCoursesLiveData: LiveData<List<Course>>
        get() = _latestCoursesLiveData

    private val _latestCoursesLiveData = MutableLiveData<List<Course>>()

    private suspend fun fetchLatestCourses(): Resource<LatestCoursesResponse> {
        return coursesRepository.getLatestCourses()
    }

    fun getLatestCourses(forceFetch: Boolean = false) = viewModelScope.launch {
        _loading.value = true
        val courses = db.getCourseDao().getCourses()
        if (courses.isEmpty() || forceFetch) {
            when (val result = fetchLatestCourses()) {
                is Resource.Success -> {
                    db.getCourseDao().addCourse(result.data?.courses)
                }
            }
        }
        _loading.value = false
        _latestCoursesLiveData.value = db.getCourseDao().getCourses()
    }

}