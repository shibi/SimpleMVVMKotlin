package com.bzcode.simplemvvmkotlin.ui.signup

import android.view.LayoutInflater

import com.bzcode.simplemvvmkotlin.databinding.ActivitySignUpBinding
import com.bzcode.simplemvvmkotlin.ui.common.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>() {

    override fun bindView(
        layoutInflater: LayoutInflater
    ): ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)

    override fun initView() {

    }
}