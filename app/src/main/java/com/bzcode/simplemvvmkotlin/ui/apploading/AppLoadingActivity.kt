package com.bzcode.simplemvvmkotlin.ui.apploading

import android.view.LayoutInflater

import com.bzcode.simplemvvmkotlin.databinding.ActivityAppLoadingBinding
import com.bzcode.simplemvvmkotlin.ui.common.BaseActivity

class AppLoadingActivity : BaseActivity<ActivityAppLoadingBinding>() {

    override fun bindView(
        layoutInflater: LayoutInflater
    ): ActivityAppLoadingBinding = ActivityAppLoadingBinding.inflate(layoutInflater)

    override fun initView() {

    }
}