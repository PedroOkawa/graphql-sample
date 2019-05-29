package me.okawa.graphqlsample.search.feature.home

import me.okawa.graphqlsample.feature.common.BaseActivity
import me.okawa.graphqlsample.search.R
import me.okawa.graphqlsample.search.di.common.inject

class HomeActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_home

    override fun doOnCreated() {
        inject()
    }

}