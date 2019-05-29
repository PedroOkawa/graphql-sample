package me.okawa.graphqlsample.di.common

import me.okawa.graphqlsample.GraphQLSampleApp
import me.okawa.graphqlsample.di.component.DaggerAppComponent

fun GraphQLSampleApp.inject() {
    DaggerAppComponent.builder()
        .application(this)
        .build()
        .inject(this)
}