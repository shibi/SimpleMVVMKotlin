package com.bzcode.simplemvvmkotlin.domain.utils.extension

import android.view.View
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

fun View.onClick(block:()->Unit){
    setOnClickListener(){block()}
}

fun View.visible(){
    visibility = View.VISIBLE
}
fun View.hide(){
    visibility = View.GONE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}
fun View.setClick(){

}
