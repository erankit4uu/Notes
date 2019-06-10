package com.ankit.demoworkingwithroom.uiController

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ankit.demoworkingwithroom.R

abstract class BaseAppActivity : AppCompatActivity() {
    lateinit var binding : ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun binding(layoutId: Int): ViewDataBinding {
        binding = DataBindingUtil.setContentView(this, layoutId)
        return binding
    }



    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
