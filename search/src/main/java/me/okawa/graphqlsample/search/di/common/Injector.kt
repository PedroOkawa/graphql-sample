package me.okawa.graphqlsample.search.di.common

import me.okawa.graphqlsample.search.di.component.DaggerSearchComponent
import me.okawa.graphqlsample.search.feature.search.SearchFragment

fun SearchFragment.inject() {
    DaggerSearchComponent
        .builder()
        .searchFragment(this)
        .build()
        .inject(this)
}