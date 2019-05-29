package me.okawa.graphqlsample.feature.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import me.okawa.graphqlsample.R
import me.okawa.graphqlsample.feature.common.BaseFragment
import java.util.*
import kotlin.concurrent.schedule

class SplashFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timer("Splash", false).schedule(500) {
            //TODO: Test to check how to open activity from another module
            val intent = Intent(Intent.ACTION_VIEW)
                .setClassName("me.okawa.graphqlsample", "me.okawa.home.HomeActivity")
            startActivity(intent)
        }
    }

}