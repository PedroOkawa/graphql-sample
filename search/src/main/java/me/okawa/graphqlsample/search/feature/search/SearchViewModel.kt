package me.okawa.graphqlsample.search.feature.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.okawa.domain.model.RepositoryEntity
import me.okawa.domain.model.SearchEntity
import me.okawa.domain.usecase.SearchUseCase
import me.okawa.graphqlsample.feature.common.BaseViewModel
import me.okawa.graphqlsample.model.Data
import me.okawa.graphqlsample.model.dataError
import me.okawa.graphqlsample.model.dataLoading
import me.okawa.graphqlsample.model.dataSuccess
import me.okawa.graphqlsample.utils.SchedulerProvider
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val schedulerProvider: SchedulerProvider,
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    companion object {
        private const val PAGE_SIZE = 10
    }

    private val searchRepositoriesData = MutableLiveData<Data<List<RepositoryEntity>>>()
    val searchRepositories: LiveData<Data<List<RepositoryEntity>>>
        get() = searchRepositoriesData

    private var cursorAfter: String? = null

    fun search(query: String) {
        searchUseCase
            .execute(query, PAGE_SIZE, cursorAfter)
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .doOnSubscribe {
                searchRepositoriesData.postValue(dataLoading())
            }
            .subscribe(
                ::onSearchSuccess,
                ::onSearchFailure
            )
            .addToDisposable()
    }

    private fun onSearchSuccess(searchEntity: SearchEntity) {
        cursorAfter = searchEntity.endCursor
        searchRepositoriesData.postValue(dataSuccess(searchEntity.repositoryEntityList))
    }

    private fun onSearchFailure(throwable: Throwable) {
        searchRepositoriesData.postValue(dataError(throwable.localizedMessage))
    }

}