package com.ankit.demoworkingwithroom.uiController

import android.content.Context

class BaseViewModel {
    lateinit var activity: BaseAppActivity
    lateinit var fragment: BaseAppFragment
//    protected var dataManager: DataManager

    fun baseViewModel(activity: BaseAppActivity) {
        this.activity = activity
//        mDataManager = DataManager.getInstance(activity.getApplicationContext())

    }

    fun baseViewModel(context: Context, fragment: BaseAppFragment){
        activity = context as BaseAppActivity
        this.fragment = fragment
//        mDataManager = DataManager.getInstance(context)
    }


//    fun getDataManager(): DataManager {
//        return mDataManager
//    }

//    fun getActivity(): TaBaseActivity {
//        return mActivity
//    }
}
