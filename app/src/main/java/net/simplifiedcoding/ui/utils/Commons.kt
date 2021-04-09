package net.simplifiedcoding.ui.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.bindImage(url: String?) {
    url?.let {
        Glide.with(this)
            .load(it)
            .into(this)
    }
}