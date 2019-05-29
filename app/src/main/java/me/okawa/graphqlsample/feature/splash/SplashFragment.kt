package me.okawa.graphqlsample.feature.splash

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import me.okawa.graphqlsample.R
import me.okawa.graphqlsample.feature.common.BaseFragment
import me.okawa.graphqlsample.utils.ActivityManager
import javax.inject.Inject

class SplashFragment : BaseFragment() {

    @Inject
    lateinit var activityManager: ActivityManager
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashViewModel

    override val layoutId: Int
        get() = R.layout.fragment_splash

    override fun doOnCreated() {
        setupInjection()
        setupViewModel()
    }

    private fun setupInjection() {
        AndroidSupportInjection.inject(this)
    }

    private fun setupViewModel() {
        viewModel = retrieveViewModel(viewModelFactory)
        viewModel.navigation.observe(this, Observer(::doOnNavigation))
        viewModel.startTimer()
    }

    private fun doOnNavigation(navigation: SplashViewModel.Navigation?) {
        when(navigation) {
            SplashViewModel.Navigation.Home -> openHomeScreen()
        }
    }

    private fun openHomeScreen() {
        val intent = activityManager.generateIntent(ActivityManager.ActivityClassName.Home)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}