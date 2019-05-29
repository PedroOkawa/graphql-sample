package me.okawa.graphqlsample.di.module

import dagger.Module
import dagger.Provides
import me.okawa.graphqlsample.utils.provider.AppSchedulerProvider
import me.okawa.graphqlsample.utils.provider.SchedulerProvider
import javax.inject.Singleton

@Module
class ProviderModule {

    @Singleton
    @Provides
    fun provideSchedulerModule(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}