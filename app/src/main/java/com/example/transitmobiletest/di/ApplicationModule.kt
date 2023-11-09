package com.example.transitmobiletest.di

import com.example.transitmobiletest.feature.feedsmap.model.api.FeedsApi
import com.example.transitmobiletest.feature.feedsmap.model.datasource.FeedsRemoteDataSource
import com.example.transitmobiletest.feature.feedsmap.model.repo.FeedsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    private const val BASE_URL = "https://api-cdn.transitapp.com/v3/"

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFeedsRepository(feedsRemoteDataSource: FeedsRemoteDataSource) = FeedsRepository(feedsRemoteDataSource)

    @Singleton
    @Provides
    fun providesFeedsRemoteDataSource(feedsApi: FeedsApi) = FeedsRemoteDataSource(feedsApi)

    @Singleton
    @Provides
    fun providesFeedsApi(retrofit: Retrofit): FeedsApi {
        return retrofit.create(FeedsApi::class.java)
    }
}