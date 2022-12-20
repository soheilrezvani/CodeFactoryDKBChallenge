package com.srn.dkbcodechallenge.app.di

import com.srn.dkbcodechallenge.data.api.PhotoApi
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
class ApiModule {

    @Provides
    @Singleton
    fun provideCardRemoteDataSource(retrofit: Retrofit): PhotoApi {
        return retrofit.create(PhotoApi::class.java)
    }
}