package me.okawa.graphqlsample.search.di.component

import dagger.BindsInstance
import dagger.Component
import me.okawa.graphqlsample.di.common.BaseFragmentComponent
import me.okawa.graphqlsample.di.module.ProviderModule
import me.okawa.graphqlsample.di.module.RepositoryModule
import me.okawa.graphqlsample.search.di.module.SearchModule
import me.okawa.graphqlsample.search.feature.search.SearchFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ProviderModule::class,
    RepositoryModule::class,
    SearchModule::class
])
interface SearchComponent : BaseFragmentComponent<SearchFragment> {

    @Component.Builder
    interface Builder {
        fun build(): SearchComponent

        @BindsInstance
        fun searchFragment(searchFragment: SearchFragment): Builder
    }
}
