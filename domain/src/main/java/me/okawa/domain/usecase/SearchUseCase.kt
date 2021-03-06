package me.okawa.domain.usecase

import io.reactivex.Observable
import me.okawa.domain.model.SearchEntity
import me.okawa.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {

    fun execute(query: String, first: Int, after: String?): Observable<SearchEntity> {
        return searchRepository.search(query, first, after)
    }

}