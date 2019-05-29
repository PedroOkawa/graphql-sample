package me.okawa.graphqlsample.search.feature.search

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.*
import me.okawa.domain.model.RepositoryEntity
import me.okawa.graphqlsample.feature.common.BaseFragment
import me.okawa.graphqlsample.model.Data
import me.okawa.graphqlsample.model.DataState
import me.okawa.graphqlsample.search.R
import me.okawa.graphqlsample.search.di.common.inject
import me.okawa.graphqlsample.utils.extensions.hideKeyboard
import javax.inject.Inject

class SearchFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SearchViewModel

    private val repositoryLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    private val repositoryAdapter: RepositoryAdapter by lazy {
        RepositoryAdapter()
    }

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

    private fun onSearchRepositories(response: Data<List<RepositoryEntity>>?) {
        when(response?.dataState) {
            DataState.LOADING -> onSearchRepositoriesLoading()
            DataState.ERROR -> onSearchRepositoriesError(response.message)
            DataState.SUCCESS -> onSearchRepositoriesSuccess(response.data)
        }
    }

    private fun onSearchRepositoriesLoading() {
        content_loading_search.show()
    }

    private fun onSearchRepositoriesError(message: String?) {
        content_loading_search.hide()
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun onSearchRepositoriesSuccess(repositories: List<RepositoryEntity>?) {
        content_loading_search.hide()
        repositories?.let {
            repositoryAdapter.addData(it)
        }
    }

    private fun setupViews() {
        button_search.setOnClickListener { onSearchButtonClicked() }
        recycler_repositories.layoutManager = repositoryLayoutManager
        recycler_repositories.adapter = repositoryAdapter
    }

    private fun onSearchButtonClicked() {
        activity?.hideKeyboard()
        repositoryAdapter.clear()
        val query = edit_text_search_query.text.toString()
        viewModel.search(query)
    }

}