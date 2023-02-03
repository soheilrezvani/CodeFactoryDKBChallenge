package com.srn.shortlyappchallenge.application.di

import com.srn.shortlyappchallenge.data.datasource.local.ApiLocalDataSource
import com.srn.shortlyappchallenge.data.datasource.local.ApiLocalDataSourceImpl
import com.srn.shortlyappchallenge.data.datasource.remote.ApiRemoteDataSource
import com.srn.shortlyappchallenge.data.datasource.remote.ApiRemoteDataSourceImpl
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

    @Provides
    @Singleton
    fun provideApiLocalDataSource(
        impl: ApiLocalDataSourceImpl,
    ): ApiLocalDataSource = impl
}