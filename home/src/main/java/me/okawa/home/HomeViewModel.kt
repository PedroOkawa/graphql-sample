package me.okawa.home

import me.okawa.domain.usecase.SearchUseCase
import me.okawa.graphqlsample.feature.common.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {



}