package com.bzcode.simplemvvmkotlin.data.remote.request

/**
 * @author shibin
 * Created 22-08-2023 at 17:42
 */
data class LoginRequest(
    val email:String,
    val phone:String
)

data class RegisterRequest(
    val name:String,
    val email:String,
    val phone:String
)
