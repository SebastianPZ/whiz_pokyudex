package com.kyuri.whizpokyudex.viewmodel.navigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kyuri.whizpokyudex.util.HOME_PAGE_TITLE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor() : ViewModel() {

    var title = MutableLiveData<String>()
    var canGoBack = MutableLiveData<Boolean>()

    init {
        setTitle(HOME_PAGE_TITLE)
        setCanGoBack(false)
    }

    fun setTitle(newTitle: String) {
        title.postValue(newTitle)
    }

    fun setCanGoBack(can: Boolean) {
        canGoBack.postValue(can)
    }

}