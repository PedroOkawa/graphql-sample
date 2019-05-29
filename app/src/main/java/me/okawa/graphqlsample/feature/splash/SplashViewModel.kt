package me.okawa.graphqlsample.feature.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.okawa.graphqlsample.feature.common.BaseViewModel
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

class SplashViewModel @Inject constructor(): BaseViewModel() {

    companion object {
        private const val TIMER_NAME = "SPLASH_DELAY"
        private const val TIMER_DELAY = 1000L
    }

    private val navigationData = MutableLiveData<Navigation>()
    val navigation: LiveData<Navigation>
        get() = navigationData

    fun startTimer() {
        Timer(TIMER_NAME, false).schedule(TIMER_DELAY) {
            navigationData.postValue(Navigation.Home)
        }
    }

    sealed class Navigation {
        object Home: Navigation()
    }

}