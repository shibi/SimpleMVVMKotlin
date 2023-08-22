package com.bzcode.simplemvvmkotlin.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bzcode.simplemvvmkotlin.data.remote.response.User
import com.bzcode.simplemvvmkotlin.domain.repository.IEmployeeRepository
import com.bzcode.simplemvvmkotlin.domain.utils.Resource
import com.bzcode.simplemvvmkotlin.ui.common.SharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author shibin
 * Created 22-08-2023 at 17:32
 */
class LoginViewModel(private val repository: IEmployeeRepository): SharedViewModel() {

    private val loginMutableLiveData = MutableLiveData<Resource<User>>()
    val loginLiveData:LiveData<Resource<User>>
        get() = loginMutableLiveData


    fun requestLogin(email:String, phone:String){
        viewModelScope.launch(Dispatchers.IO){
            val result = repository.requestLogin(email, phone)
            loginMutableLiveData.postValue(result.value)
        }
    }

    class Factory(private val repository: IEmployeeRepository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return LoginViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }

    }

}