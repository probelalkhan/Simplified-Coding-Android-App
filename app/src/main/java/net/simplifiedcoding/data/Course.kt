package net.simplifiedcoding.data

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Courses")
@Parcelize
@Keep
data class Course(
    val author_name: String,
    val category_name: String,
    val content: String?,
    val featured_image: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val lessons_count: Int,
    val short_desc: String,
    val slug: String,
    val title: String,
    val updated_at: String,
) : Parcelable 