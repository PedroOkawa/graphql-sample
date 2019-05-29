package me.okawa.data.mapper

import com.apollographql.apollo.sample.fragment.OwnerFragment
import me.okawa.domain.model.OwnerEntity
import javax.inject.Inject

class OwnerMapper @Inject constructor() {

    fun map(ownerFragment: OwnerFragment?): OwnerEntity? {
        ownerFragment ?: return null
        return OwnerEntity(
            ownerFragment.avatarUrl(),
            ownerFragment.login()
        )
    }

}