package net.simplifiedcoding.data.repositories

import net.simplifiedcoding.data.BaseRepository
import net.simplifiedcoding.data.network.SimplifiedCodingApi

class CoursesRepository(private val coursesApi: SimplifiedCodingApi) : BaseRepository() {
    suspend fun getLatestCourses() = safeApiCall { coursesApi.getLatestCourses() }
}