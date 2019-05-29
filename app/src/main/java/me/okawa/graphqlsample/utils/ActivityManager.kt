package me.okawa.graphqlsample.utils

import android.content.Intent
import javax.inject.Inject

class ActivityManager @Inject constructor() {

    companion object {
        private const val PACKAGE_NAME = "me.okawa.graphqlsample"
        private const val HOME_ACTIVITY_NAME = ".search.feature.home.HomeActivity"
    }

    fun generateIntent(activityClassName: ActivityClassName): Intent {
        return Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, activityClassName.name)
    }

    sealed class ActivityClassName(val name: String) {
        object Home : ActivityClassName("$PACKAGE_NAME$HOME_ACTIVITY_NAME")
    }

}