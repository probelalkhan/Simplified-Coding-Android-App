package net.simplifiedcoding.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<I : Any, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.Companion.BaseViewHolder<VB>>() {

    var items: List<I>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(getItemViewBinding(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = items?.size ?: 0

    abstract fun getItemViewBinding(inflater: LayoutInflater): VB

    companion object {
        class BaseViewHolder<VB : ViewBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)
    }
}