package me.okawa.data.mapper

import com.apollographql.apollo.sample.SearchQuery
import me.okawa.domain.model.RepositoryEntity
import javax.inject.Inject

class RepositoryMapper @Inject constructor(
    private val ownerMapper: OwnerMapper
) {

    fun map(nodes: List<SearchQuery.Node>?): List<RepositoryEntity> {
        return nodes?.map { node -> mapItem(node) } ?: emptyList()
    }

    private fun mapItem(node: SearchQuery.Node): RepositoryEntity {
        val nameWithOwner = node.fragments().repositoryFragment()?.nameWithOwner()
        val description = node.fragments().repositoryFragment()?.description()
        val ownerFragment = node.fragments().repositoryFragment()?.owner()?.fragments()?.ownerFragment()

        return RepositoryEntity(
            nameWithOwner,
            description,
            ownerMapper.map(ownerFragment)
        )
    }

}