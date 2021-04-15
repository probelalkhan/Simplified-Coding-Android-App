package net.simplifiedcoding.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.simplifiedcoding.data.db.SimplifiedCodingDatabase
import net.simplifiedcoding.data.network.RetrofitClient
import net.simplifiedcoding.data.network.SimplifiedCodingApi
import net.simplifiedcoding.data.repositories.CoursesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provide(): RetrofitClient {
        return RetrofitClient()
    }

    @Singleton
    @Provides
    fun provideApi(
        retrofitClient: RetrofitClient
    ): SimplifiedCodingApi {
        return retrofitClient.buildApi(SimplifiedCodingApi::class.java)
    }

    @Provides
    fun provideCourseRepository(
        api: SimplifiedCodingApi
    ): CoursesRepository {
        return CoursesRepository(api)
    }

    @Singleton
    @Provides
    fun provideSimplifiedCodingDatabase(
        @ApplicationContext context: Context
    ): SimplifiedCodingDatabase {
        return SimplifiedCodingDatabase(context)
    }
}