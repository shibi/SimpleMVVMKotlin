package com.bzcode.simplemvvmkotlin.ui.common

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * @author shibin
 * Created 22-08-2023 at 16:58
 */
abstract class BaseActivity<T: ViewBinding> : AppCompatActivity() {

    private val TAG = "----------"
    lateinit var binding:T
    private lateinit var loadingDialog: AlertDialog
    private var isLoadingInitialized: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        onPreCreate()
        super.onCreate(savedInstanceState)

        binding = bindView(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    protected open fun onPreCreate(){
    }

    protected abstract fun bindView(layoutInflater: LayoutInflater):T

    protected abstract fun initView()

    protected fun showToast(message:String){
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
    }

    protected fun loge(message: String){
        Log.e(TAG, message)
    }

    fun <S> redirectTo(destination:Class<S>, keepHistory: Boolean){
        val destinationIntent = Intent(this, destination)
        startActivity(destinationIntent)
        if(!keepHistory){
            finish()
        }
    }
    fun <S> redirectWithFlagTo(destination:Class<S>, keepHistory: Boolean, block:(intent: Intent)->Unit){
        val destinationIntent = Intent(this, destination)
        //
        block(destinationIntent)
        //
        startActivity(destinationIntent)
        if(!keepHistory){
            finish()
        }
    }

    protected fun showLoading(isLoading:Boolean){
        //proceed only if dialog box initialized
        if(!isLoadingInitialized)
            return

        if(isLoading){
            if(!loadingDialog.isShowing) {
                loadingDialog.show()
            }
        }
        else loadingDialog.dismiss()
    }

}