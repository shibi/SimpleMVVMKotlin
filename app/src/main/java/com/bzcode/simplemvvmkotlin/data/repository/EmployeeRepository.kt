package com.bzcode.simplemvvmkotlin.data.repository

import androidx.lifecycle.LiveData
import com.bzcode.simplemvvmkotlin.data.remote.api.ApiService
import com.bzcode.simplemvvmkotlin.data.remote.response.RegisterResponse
import com.bzcode.simplemvvmkotlin.data.remote.response.User
import com.bzcode.simplemvvmkotlin.domain.repository.IEmployeeRepository
import com.bzcode.simplemvvmkotlin.domain.utils.Resource

/**
 * @author shibin
 * Created 22-08-2023 at 17:51
 */
class EmployeeRepository(private val apiService: ApiService): IEmployeeRepository {

    override fun requestLogin(email: String, phone: String): LiveData<Resource<User>> {
        TODO("Not yet implemented")
    }

    override fun registerUser(
        name: String,
        email: String,
        phone: String
    ): LiveData<Resource<RegisterResponse>> {
        TODO("Not yet implemented")
    }

}