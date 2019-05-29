package me.okawa.domain.model

data class RepositoryData(
    val nameWithOwner: String?,
    val description: String?,
    val ownerData: OwnerData?
)