package com.bzcode.simplemvvmkotlin.ui.login

import android.view.LayoutInflater

import com.bzcode.simplemvvmkotlin.databinding.ActivityLoginBinding
import com.bzcode.simplemvvmkotlin.domain.utils.extension.isNotFilled
import com.bzcode.simplemvvmkotlin.ui.common.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun bindView(
        layoutInflater: LayoutInflater
    ): ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)

    override fun initView() {

        binding.btnSignIn.setOnClickListener {
            if(validate()){

            }
        }

    }

    private fun validate():Boolean{
        binding.apply {

            if(etEmail.isNotFilled("Please enter email")){
                return false
            }

            if(etPhone.isNotFilled("Please enter Phone")){
                return false
            }

            return true
        }
    }
}