package me.okawa.graphqlsample.search.feature.search

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_search.*
import me.okawa.domain.model.RepositoryEntity
import me.okawa.graphqlsample.feature.common.BaseFragment
import me.okawa.graphqlsample.model.Data
import me.okawa.graphqlsample.model.DataState
import me.okawa.graphqlsample.search.R
import me.okawa.graphqlsample.search.di.common.inject
import javax.inject.Inject

class SearchFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SearchViewModel

    override val layoutId: Int
        get() = R.layout.fragment_search

    override fun doOnCreated() {
        inject()
        setupViewModel()
        setupViews()
    }

    private fun setupViewModel() {
        viewModel = retrieveViewModel(viewModelFactory)
        viewModel.searchRepositories.observe(this, Observer(::onSearchRepositories))
    }

    private fun setupViews() {
        button_search.setOnClickListener {
            val query = edit_text_search_query.text.toString()
            viewModel.search(query)
        }
    }

    private fun onSearchRepositories(response: Data<List<RepositoryEntity>>?) {
        when(response?.dataState) {
            DataState.LOADING -> {}
            DataState.ERROR -> {}
            DataState.SUCCESS -> {
                Log.w("TEST", "DATA: ${response.data}")
            }
        }
    }

}