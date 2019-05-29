package me.okawa.graphqlsample.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.okawa.graphqlsample.feature.splash.SplashViewModel
import me.okawa.graphqlsample.utils.ViewModelKey

@Module(includes = [ ViewModelModule::class ])
abstract class SplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

}