package net.simplifiedcoding.ui.home

import android.view.LayoutInflater
import net.simplifiedcoding.data.Course
import net.simplifiedcoding.databinding.ItemCourseBinding
import net.simplifiedcoding.ui.base.BaseRecyclerViewAdapter

class CoursesAdapter : BaseRecyclerViewAdapter<Course, ItemCourseBinding>() {

    override fun getItemViewBinding(inflater: LayoutInflater): ItemCourseBinding =
        ItemCourseBinding.inflate(inflater)

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemCourseBinding>,
        position: Int
    ) {
        items?.let {
            holder.binding.textView.text = it[position].title
        }
    }
}