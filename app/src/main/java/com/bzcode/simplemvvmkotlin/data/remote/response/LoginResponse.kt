package com.bzcode.simplemvvmkotlin.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * @author shibin
 * Created 22-08-2023 at 17:37
 */
data class LoginResponse(
    @SerializedName("status")
    private var status: Boolean? = null,
    @SerializedName("message")
    private val message: String? = null,
    @SerializedName("data")
    private var data: User? = null
)

data class User(
    @SerializedName("userid")
    private var userid: String? = null,
    @SerializedName("name")
    private val name: String? = null,
    @SerializedName("email")
    private val email: String? = null,
    @SerializedName("phone")
    private val phone: String? = null
)