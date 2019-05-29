package me.okawa.graphqlsample.search.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.okawa.graphqlsample.di.module.ViewModelModule
import me.okawa.graphqlsample.search.feature.search.SearchViewModel
import me.okawa.graphqlsample.utils.viewmodel.ViewModelKey

@Module(includes = [ ViewModelModule::class ])
abstract class SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

}