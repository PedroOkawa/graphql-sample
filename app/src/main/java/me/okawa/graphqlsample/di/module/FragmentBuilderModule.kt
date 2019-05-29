package me.okawa.graphqlsample.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.okawa.graphqlsample.feature.splash.SplashFragment

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

}