package me.okawa.data.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.apollographql.apollo.sample.SearchQuery
import com.apollographql.apollo.sample.type.SearchType
import io.reactivex.Observable
import me.okawa.data.mapper.SearchMapper
import me.okawa.domain.model.SearchEntity
import me.okawa.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient,
    private val searchMapper: SearchMapper
): SearchRepository {

    companion object {
        private val SEARCH_TYPE = SearchType.REPOSITORY
    }

    override fun search(query: String, first: Int, after: String?): Observable<SearchEntity> {
        val searchQuery = SearchQuery.builder()
            .type(SEARCH_TYPE)
            .query(query)
            .first(first)
            .after(after)
            .build()

        return Rx2Apollo.from(apolloClient.query(searchQuery))
            .flatMap { response ->
                if (response.hasErrors()) {
                    val message = response.errors().map { error -> error.message() }.joinToString(separator = "\n")
                    Observable.error(Throwable(message))
                } else {
                    Observable.just(response.data())
                }
            }
            .map {
                searchMapper.map(it)
            }
    }

}