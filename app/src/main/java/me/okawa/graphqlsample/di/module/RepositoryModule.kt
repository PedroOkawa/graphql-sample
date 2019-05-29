package me.okawa.graphqlsample.di.module

import dagger.Binds
import dagger.Module
import me.okawa.data.repository.SearchRepositoryImpl
import me.okawa.domain.repository.SearchRepository

@Module(includes = [ ApiModule::class ])
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl) : SearchRepository

}