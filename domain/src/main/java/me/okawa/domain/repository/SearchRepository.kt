package me.okawa.domain.repository

import io.reactivex.Observable
import me.okawa.domain.model.SearchEntity

interface SearchRepository {

    fun search(query: String, first: Int, after: String?): Observable<SearchEntity>

}