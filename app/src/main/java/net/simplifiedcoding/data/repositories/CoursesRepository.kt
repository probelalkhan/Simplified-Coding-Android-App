package net.simplifiedcoding.data.repositories

import net.simplifiedcoding.data.network.SimplifiedCodingApi

class CoursesRepository(private val coursesApi: SimplifiedCodingApi) {
    suspend fun getLatestCourses() = coursesApi.getLatestCourses()
}