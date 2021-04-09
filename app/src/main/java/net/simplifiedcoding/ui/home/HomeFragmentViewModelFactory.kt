package net.simplifiedcoding.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.simplifiedcoding.data.repositories.CoursesRepository

class HomeFragmentViewModelFactory(
        private val repository: CoursesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return HomeFragmentViewModel(repository) as T
    }
}