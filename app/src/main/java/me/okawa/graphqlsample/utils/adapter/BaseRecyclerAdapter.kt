package me.okawa.graphqlsample.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseRecyclerAdapter<T>(
    private var data: ArrayList<T> = arrayListOf()
): RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>() {

    abstract fun doOnBindViewHolder(item: T, holder: BaseViewHolder, position: Int)

    @LayoutRes
    abstract fun layoutToInflate(viewType: Int): Int

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(layoutToInflate(viewType), parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = data[position]
        doOnBindViewHolder(item, holder, position)
    }

    fun setData(items: List<T>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun addData(items: List<T>) {
        val index = itemCount
        data.addAll(index, items)
        notifyItemRangeInserted(index, itemCount)
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    class BaseViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer

}