package com.bzcode.simplemvvmkotlin.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * @author shibin
 * Created 22-08-2023 at 17:37
 */
data class RegisterResponse(
    @SerializedName("status")
    private var status: Boolean? = null,
    @SerializedName("message")
    private val message: String? = null,
    @SerializedName("data")
    private val data: String? = null
)

