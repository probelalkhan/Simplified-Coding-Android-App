package net.simplifiedcoding.ui.home

import android.view.LayoutInflater
import net.simplifiedcoding.data.Course
import net.simplifiedcoding.databinding.ItemCourseBinding
import net.simplifiedcoding.ui.base.BaseRecyclerViewAdapter
import net.simplifiedcoding.ui.utils.bindImage

class CoursesAdapter : BaseRecyclerViewAdapter<Course, ItemCourseBinding>() {

    override fun getItemViewBinding(inflater: LayoutInflater): ItemCourseBinding =
        ItemCourseBinding.inflate(inflater)

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemCourseBinding>,
        position: Int
    ) {
        super.onBindViewHolder(holder, position)
        items?.let {
            holder.binding.textView.text = it[position].title
            holder.binding.imageView.bindImage(it[position].featured_image)
        }
    }
}