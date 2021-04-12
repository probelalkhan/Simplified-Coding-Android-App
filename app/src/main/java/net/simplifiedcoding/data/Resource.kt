package net.simplifiedcoding.data

sealed class Resource<T> {
    data class Success<T>(val data: T?) : Resource<T>()
    data class Failure<T>(val failure: T?) : Resource<T>()
    data class Loading<T>(val data: T? = null) : Resource<T>()
}