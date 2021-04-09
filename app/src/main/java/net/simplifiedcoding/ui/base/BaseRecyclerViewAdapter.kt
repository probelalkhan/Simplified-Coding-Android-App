package net.simplifiedcoding.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<I : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.Companion.BaseViewHolder<VB>>() {

    var recyclerViewItemClickListener: ((position: Int, item: I?, view: View) -> Unit)? = null

    var items: List<I>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(getItemViewBinding(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        holder.binding.root.setOnClickListener {
            recyclerViewItemClickListener?.invoke(position, items?.get(position), it)
        }
    }

    override fun getItemCount() = items?.size ?: 0

    abstract fun getItemViewBinding(inflater: LayoutInflater): VB

    companion object {
        class BaseViewHolder<VB : ViewBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)
    }
}