package me.okawa.graphqlsample.search.feature.search

import kotlinx.android.synthetic.main.adapter_repository.view.*
import me.okawa.domain.model.RepositoryEntity
import me.okawa.graphqlsample.search.R
import me.okawa.graphqlsample.utils.adapter.BaseRecyclerAdapter

class RepositoryAdapter : BaseRecyclerAdapter<RepositoryEntity>() {

    override fun doOnBindViewHolder(item: RepositoryEntity, holder: BaseViewHolder, position: Int) {
        holder.containerView.apply {
            text_title.text = item.nameWithOwner
            text_description.text = item.description
        }
    }

    override fun layoutToInflate(viewType: Int): Int = R.layout.adapter_repository
}