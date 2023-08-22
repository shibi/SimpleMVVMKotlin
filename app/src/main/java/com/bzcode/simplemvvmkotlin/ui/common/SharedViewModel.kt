package com.bzcode.simplemvvmkotlin.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author shibin
 * Created 22-08-2023 at 17:58
 */
open class SharedViewModel : ViewModel(){

    private val loading = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = loading

    fun setLoading(isLoading: Boolean){
        loading.postValue(isLoading)
    }
}