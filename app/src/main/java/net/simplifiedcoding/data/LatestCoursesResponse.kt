package net.simplifiedcoding.data

import androidx.annotation.Keep

@Keep
data class LatestCoursesResponse(
    val courses: List<Course>
)