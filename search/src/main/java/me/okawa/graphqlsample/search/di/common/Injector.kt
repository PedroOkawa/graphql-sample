package me.okawa.graphqlsample.search.di.common

import me.okawa.graphqlsample.search.di.component.DaggerHomeComponent
import me.okawa.graphqlsample.search.di.component.DaggerSearchComponent
import me.okawa.graphqlsample.search.feature.home.HomeActivity
import me.okawa.graphqlsample.search.feature.search.SearchFragment

fun HomeActivity.inject() {
    DaggerHomeComponent.builder()
        .homeActivity(this)
        .build()
        .inject(this)
}

fun SearchFragment.inject() {
    DaggerSearchComponent
        .builder()
        .searchFragment(this)
        .build()
        .inject(this)
}