package me.okawa.data.mapper

import com.apollographql.apollo.sample.SearchQuery
import me.okawa.domain.model.RepositoryData
import me.okawa.domain.model.SearchData
import javax.inject.Inject

class RepositoryMapper @Inject constructor(
    private val ownerMapper: OwnerMapper
) {

    fun map(nodes: List<SearchQuery.Node>?): List<RepositoryData> {
        return nodes?.map { node -> mapItem(node) } ?: emptyList()
    }

    private fun mapItem(node: SearchQuery.Node): RepositoryData {
        val nameWithOwner = node.fragments().repositoryFragment()?.nameWithOwner()
        val description = node.fragments().repositoryFragment()?.description()
        val ownerFragment = node.fragments().repositoryFragment()?.owner()?.fragments()?.ownerFragment()

        return RepositoryData(
            nameWithOwner,
            description,
            ownerMapper.map(ownerFragment)
        )
    }

}