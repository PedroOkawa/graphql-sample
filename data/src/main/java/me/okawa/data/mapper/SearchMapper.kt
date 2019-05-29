package me.okawa.data.mapper

import com.apollographql.apollo.sample.SearchQuery
import me.okawa.domain.model.SearchData
import javax.inject.Inject

class SearchMapper @Inject constructor(
    private val repositoryMapper: RepositoryMapper
) {

    fun map(searchQueryData: SearchQuery.Data?): SearchData? {
        searchQueryData ?: return null

        val search = searchQueryData.search()
        val pageInfoFragment = search.pageInfo().fragments().pageInfoFragment()
        val hasNextPage = pageInfoFragment.hasNextPage()
        val endCursor = pageInfoFragment.endCursor()
        val repositoryDataList = repositoryMapper.map(search.nodes())

        return SearchData(hasNextPage, endCursor, repositoryDataList)
    }

}