package net.simplifiedcoding.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://admin.simplifiedcoding.in/api/"
    }

    fun buildApi(api: Class<SimplifiedCodingApi>): SimplifiedCodingApi{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
    }
}