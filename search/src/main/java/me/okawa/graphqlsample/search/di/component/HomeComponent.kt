package me.okawa.graphqlsample.search.di.component

import dagger.BindsInstance
import dagger.Component
import me.okawa.graphqlsample.di.common.BaseActivityComponent
import me.okawa.graphqlsample.di.common.FeatureScope
import me.okawa.graphqlsample.search.feature.home.HomeActivity

@FeatureScope
@Component
interface HomeComponent : BaseActivityComponent<HomeActivity> {

    @Component.Builder
    interface Builder {
        fun build(): HomeComponent

        @BindsInstance
        fun homeActivity(homeActivity: HomeActivity): Builder
    }
}
