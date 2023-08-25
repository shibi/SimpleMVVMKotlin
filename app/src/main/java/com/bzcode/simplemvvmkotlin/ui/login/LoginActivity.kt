package com.bzcode.simplemvvmkotlin.ui.login

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.bzcode.simplemvvmkotlin.data.remote.api.ApiService
import com.bzcode.simplemvvmkotlin.data.repository.EmployeeRepository

import com.bzcode.simplemvvmkotlin.databinding.ActivityLoginBinding
import com.bzcode.simplemvvmkotlin.domain.utils.Resource
import com.bzcode.simplemvvmkotlin.domain.utils.extension.isNotFilled
import com.bzcode.simplemvvmkotlin.domain.utils.extension.onClick
import com.bzcode.simplemvvmkotlin.ui.common.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private lateinit var loginViewModel: LoginViewModel

    override fun bindView(
        layoutInflater: LayoutInflater
    ): ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)

    override fun initView() {

        val apiService = ApiService.getInstance()
        val repository = EmployeeRepository(apiService)
        loginViewModel = ViewModelProvider(
            this,
            LoginViewModel.Factory(repository)
        ).get(LoginViewModel::class.java)

        setObserver()

        binding.btnSignIn.onClick {
            if (validate()) {
                loginViewModel.requestLogin(
                    binding.etEmail.text.toString(),
                    binding.etPhone.text.toString()
                )
            }
        }


    }

    private fun setObserver() {

        loginViewModel.loadingState.observe(this) { isLoading ->
            showLoading(isLoading)
        }

        loginViewModel.loginLiveData.observe(this) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    showToast("Login success")
                    //redirectTo()
                }

                is Resource.Error -> {
                    showToast(it.error ?: "Error occurred")
                }
            }
        }

    }

    private fun validate(): Boolean {
        binding.apply {

            if (etEmail.isNotFilled("Please enter email")) {
                return false
            }

            if (etPhone.isNotFilled("Please enter Phone")) {
                return false
            }

            return true
        }
    }
}