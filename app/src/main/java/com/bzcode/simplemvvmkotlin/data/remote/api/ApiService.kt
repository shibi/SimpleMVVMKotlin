package com.bzcode.simplemvvmkotlin.data.remote.api

import com.bzcode.simplemvvmkotlin.data.remote.request.LoginRequest
import com.bzcode.simplemvvmkotlin.data.remote.request.RegisterRequest
import com.bzcode.simplemvvmkotlin.data.remote.response.LoginResponse
import com.bzcode.simplemvvmkotlin.data.remote.response.RegisterResponse
import com.bzcode.simplemvvmkotlin.domain.utils.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

/**
 * @author shibin
 * Created 22-08-2023 at 17:32
 */
interface ApiService {

    companion object{

        private var apiService: ApiService? = null

        fun getInstance() : ApiService {

            if(apiService == null){

                val gson = GsonBuilder()
                    .setLenient()
                    .create()

                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                val builder = OkHttpClient.Builder()
                builder.addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .addInterceptor { chain ->
                        val newRequest = chain.request().newBuilder()
                            .build()
                        chain.proceed(newRequest)
                    }

                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl(Constants.DOMAIN_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(builder.build())
                    .build()

                apiService = retrofitBuilder.create(ApiService::class.java)
            }

            return apiService!!
        }
    }

    @POST("mockLogin")
    suspend fun requestLogin(@Body request: LoginRequest): Response<LoginResponse>

    @POST("mockRegister")
    suspend fun requestSignUp(@Body request: RegisterRequest): Response<RegisterResponse>


}