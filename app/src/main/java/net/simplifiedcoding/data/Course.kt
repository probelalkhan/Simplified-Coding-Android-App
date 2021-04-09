package net.simplifiedcoding.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Course(
    val author_name: String,
    val category_name: String,
    val content: String?,
    val featured_image: String,
    val id: Int,
    val lessons_count: Int,
    val short_desc: String,
    val slug: String,
    val title: String,
    val updated_at: String,
) : Parcelable 