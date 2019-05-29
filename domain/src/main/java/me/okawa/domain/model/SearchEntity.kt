package me.okawa.domain.model

data class SearchEntity(
    val hasNextPage: Boolean,
    val endCursor: String?,
    val repositoryEntityList: List<RepositoryEntity>
)