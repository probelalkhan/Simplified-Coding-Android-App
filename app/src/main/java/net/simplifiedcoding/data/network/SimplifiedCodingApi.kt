package net.simplifiedcoding.data.network

import net.simplifiedcoding.data.LatestCoursesResponse
import retrofit2.http.GET

interface SimplifiedCodingApi {

    @GET("course/latest")
    suspend fun getLatestCourses(): LatestCoursesResponse

}