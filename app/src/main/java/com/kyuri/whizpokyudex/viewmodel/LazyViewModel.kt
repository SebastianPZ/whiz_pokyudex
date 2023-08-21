package com.kyuri.whizpokyudex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class LazyViewModel : ViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun setLoading(status: Boolean) {
        if(!loading.equals(status)) loading.postValue(status)
    }

}