package net.simplifiedcoding.di

import net.simplifiedcoding.data.network.RetrofitClient
import net.simplifiedcoding.data.network.SimplifiedCodingApi
import net.simplifiedcoding.data.repositories.CoursesRepository

class DependencyContainer {
    private val retrofit = RetrofitClient()
    private val api = retrofit.buildApi(SimplifiedCodingApi::class.java)
    val repository = CoursesRepository(api)
}