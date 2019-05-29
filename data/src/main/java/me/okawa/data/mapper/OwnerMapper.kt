package me.okawa.data.mapper

import com.apollographql.apollo.sample.fragment.OwnerFragment
import me.okawa.domain.model.OwnerData
import javax.inject.Inject

class OwnerMapper @Inject constructor() {

    fun map(ownerFragment: OwnerFragment?): OwnerData? {
        ownerFragment ?: return null
        return OwnerData(ownerFragment.avatarUrl(), ownerFragment.login())
    }

}