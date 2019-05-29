package me.okawa.home

import dagger.Component
import me.okawa.graphqlsample.di.component.AppInjector

@Component(
    dependencies = [ AppInjector::class ]
)
interface HomeInjector