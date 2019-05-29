package me.okawa.domain.model

import java.net.URI

data class OwnerEntity(
    val avatarUrl: URI?,
    val login: String?
)