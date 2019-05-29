package me.okawa.graphqlsample.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import me.okawa.graphqlsample.GraphQLSampleApp
import me.okawa.graphqlsample.di.module.RepositoryModule
import me.okawa.graphqlsample.di.module.ViewModelModule
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(modules = [
    RepositoryModule::class,
    ViewModelModule::class
])
abstract class AppInjector: AndroidInjector<GraphQLSampleApp> {

    @Component.Builder
    interface Builder {
        fun build(): AppInjector

        @BindsInstance
        fun application(application: Application): Builder
    }

}