package com.srn.shortlyappchallenge.application.di

import com.srn.shortlyappchallenge.data.api.ShortenApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by SoheilR .
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ShortenApi {
        return retrofit.create(ShortenApi::class.java)
    }
}