package me.okawa.home

import android.os.Bundle
import android.util.Log
import me.okawa.graphqlsample.feature.common.BaseActivity

class HomeActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}