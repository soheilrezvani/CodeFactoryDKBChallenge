package com.srn.dkbcodechallenge.app.di

import com.srn.dkbcodechallenge.data.datasource.PhotoRemoteDataSource
import com.srn.dkbcodechallenge.data.datasource.PhotoRemoteDataSourceImpl
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
    fun providesAuthRemoteDataSource(
        impl: PhotoRemoteDataSourceImpl,
    ): PhotoRemoteDataSource = impl
}
