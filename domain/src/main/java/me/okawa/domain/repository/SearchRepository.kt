package me.okawa.domain.repository

import io.reactivex.Observable
import me.okawa.domain.model.SearchData

interface SearchRepository {

    fun search(query: String, first: Int, after: String): Observable<SearchData>

}