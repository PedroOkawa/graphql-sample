package me.okawa.graphqlsample.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.okawa.graphqlsample.feature.main.MainActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}