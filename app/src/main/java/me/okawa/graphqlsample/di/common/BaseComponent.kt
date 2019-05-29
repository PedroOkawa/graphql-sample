package me.okawa.graphqlsample.di.common

import android.app.Activity
import androidx.fragment.app.Fragment

interface BaseActivityComponent<T : Activity> {

    fun inject(target: T)

}

interface BaseFragmentComponent<T : Fragment> {

    fun inject(target: T)

}