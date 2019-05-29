package me.okawa.graphqlsample.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.okawa.graphqlsample.GraphQLSampleApp
import me.okawa.graphqlsample.di.module.*
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class,
    ProviderModule::class,
    RepositoryModule::class,
    SplashModule::class
])
interface AppComponent: AndroidInjector<GraphQLSampleApp> {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}