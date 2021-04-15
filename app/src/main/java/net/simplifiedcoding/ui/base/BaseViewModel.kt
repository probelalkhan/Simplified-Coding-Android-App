package net.simplifiedcoding.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val loading: LiveData<Boolean>
        get() = _loading

    protected val _loading = MutableLiveData<Boolean>()
}