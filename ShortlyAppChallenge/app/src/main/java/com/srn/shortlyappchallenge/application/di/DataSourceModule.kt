package com.srn.shortlyappchallenge.application.di

import com.srn.shortlyappchallenge.data.datasource.ApiRemoteDataSource
import com.srn.shortlyappchallenge.data.datasource.ApiRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by SoheilR .
 */
@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideApiRemoteDataSource(
        impl: ApiRemoteDataSourceImpl,
    ): ApiRemoteDataSource = impl
}