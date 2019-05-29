package me.okawa.domain.model

data class RepositoryEntity(
    val nameWithOwner: String?,
    val description: String?,
    val ownerEntity: OwnerEntity?
)