package me.okawa.graphqlsample.feature.main

import dagger.android.AndroidInjection
import me.okawa.graphqlsample.R
import me.okawa.graphqlsample.feature.common.BaseActivity

class MainActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun doOnCreated() {
        AndroidInjection.inject(this)
    }

}