package com.bzcode.simplemvvmkotlin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.bzcode.simplemvvmkotlin.data.remote.api.ApiService
import com.bzcode.simplemvvmkotlin.data.remote.request.LoginRequest
import com.bzcode.simplemvvmkotlin.data.remote.request.RegisterRequest
import com.bzcode.simplemvvmkotlin.data.remote.response.LoginResponse
import com.bzcode.simplemvvmkotlin.data.remote.response.RegisterResponse
import com.bzcode.simplemvvmkotlin.data.remote.response.User
import com.bzcode.simplemvvmkotlin.domain.repository.IEmployeeRepository
import com.bzcode.simplemvvmkotlin.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlin.Exception

/**
 * @author shibin
 * Created 22-08-2023 at 17:51
 */
class EmployeeRepository(private val apiService: ApiService): IEmployeeRepository {

    override suspend fun requestLogin(email: String, phone: String): LiveData<Resource<User>> {
        val statusLiveData = MediatorLiveData<Resource<User>>()
        try {
            val request = LoginRequest(email, phone)
            val response = apiService.requestLogin(request)
            if(response.isSuccessful){
                val loginResponse:LoginResponse? = response.body()
                loginResponse?.let {
                    val user = it.data
                    statusLiveData.postValue(Resource.Success(user!!))
                }?: kotlin.run {
                    statusLiveData.postValue(Resource.Error(response.message()))
                }

            }else{
                statusLiveData.postValue(Resource.Error(response.message()))
            }

        }catch (e:Exception){
            statusLiveData.postValue(Resource.Error(e.message?:"Login error"))
        }
        return statusLiveData
    }

    override suspend fun registerUser(
        name: String,
        email: String,
        phone: String
    ): LiveData<Resource<RegisterResponse>> {
        val statusLiveData = MediatorLiveData<Resource<RegisterResponse>>()

        withContext(Dispatchers.IO){
            try {

                val request = RegisterRequest(name, email, phone)
                val response = apiService.requestSignUp(request)
                if(response.isSuccessful){
                    statusLiveData.postValue(Resource.Success(response.body()!!))
                }else{
                    statusLiveData.postValue(Resource.Error(response.message()))
                }

            }catch (e:Exception){

            }
        }
        return statusLiveData
    }

    override suspend fun requestEmployeeLogin(email: String, phone: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading(null))
        val request = LoginRequest(email, phone)
        val response = apiService.requestLogin(request)
        if(response.isSuccessful){
            val loginResponse:LoginResponse? = response.body()
            loginResponse?.let {
                val user = it.data
                emit(Resource.Success(user!!))
            }?: kotlin.run {
                emit(Resource.Error(response.message()))
            }

        }else{
            emit(Resource.Error(response.message()))
        }
    }


}