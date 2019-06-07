package com.ankit.demoworkingwithroom.uiController

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ankit.demoworkingwithroom.uiController.BaseViewModel

class BaseAppFragment: Fragment() {

    lateinit var binding: ViewDataBinding
    lateinit var viewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
     fun binding(
        inflater: LayoutInflater,
        container: ViewGroup,
        layoutId: Int,
        viewModel: BaseViewModel
    ): ViewDataBinding {
        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, container, false)
        binding.setVariable(2, viewModel)
        this.viewModel = viewModel
        return binding
    }

}