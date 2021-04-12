package net.simplifiedcoding.data

import java.lang.Exception

abstract class BaseRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return try{
            Resource.Success(apiCall.invoke())
        }catch (e: Exception){
            Resource.Failure(e.message as T)
        }
    }
}