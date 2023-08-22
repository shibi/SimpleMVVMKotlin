package com.bzcode.simplemvvmkotlin.domain.utils.extension

import androidx.appcompat.widget.AppCompatEditText

/**
 * @author shibin
 * Created 22-08-2023 at 17:20
 */

fun AppCompatEditText.isNotFilled(errorMsg:String) : Boolean{

    val value = text?:""
    if(value.isEmpty()){
        error = errorMsg
        requestFocus()
        return false
    }

    return true
}