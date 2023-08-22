package com.bzcode.simplemvvmkotlin.domain.repository

import androidx.lifecycle.LiveData
import com.bzcode.simplemvvmkotlin.data.remote.response.RegisterResponse
import com.bzcode.simplemvvmkotlin.data.remote.response.User
import com.bzcode.simplemvvmkotlin.domain.utils.Resource

/**
 * @author shibin
 * Created 22-08-2023 at 17:47
 */
interface IEmployeeRepository {

    suspend fun requestLogin(email: String, phone: String): LiveData<Resource<User>>

    suspend fun registerUser(name: String, email: String, phone: String): LiveData<Resource<RegisterResponse>>

}