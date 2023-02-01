package com.srn.shortlyappchallenge.application.di

import com.srn.shortlyappchallenge.data.repository.ApiRepositoryImpl
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
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
class RepositoryModule {

    @Provides
    @Singleton
    fun provideApiRepository(
        impl: ApiRepositoryImpl,
    ): ApiRepository = impl
}