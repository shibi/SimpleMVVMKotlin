package com.bzcode.simplemvvmkotlin.domain.utils

/**
 * @author shibin
 * Created 22-08-2023 at 17:48
 */
sealed class Resource<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(errorCode: String) : Resource<T>(null, errorCode)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            is Loading<T> -> "Loading"
        }
    }
}