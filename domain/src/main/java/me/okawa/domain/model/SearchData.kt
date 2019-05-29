package me.okawa.domain.model

data class SearchData(
    val hasNextPage: Boolean,
    val endCursor: String?,
    val repositoryDataList: List<RepositoryData>
)