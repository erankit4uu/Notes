package com.ankit.demoworkingwithroom.uiController

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ankit.demoworkingwithroom.R

abstract class BaseAppActivity : AppCompatActivity() {
    lateinit var binding : ViewDataBinding
    lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun binding(layoutId: Int, viewModel: BaseViewModel): ViewDataBinding {
        binding = DataBindingUtil.setContentView(this, layoutId)
        this.viewModel = viewModel
        binding.setVariable(2, viewModel)
        return binding
    }
}
