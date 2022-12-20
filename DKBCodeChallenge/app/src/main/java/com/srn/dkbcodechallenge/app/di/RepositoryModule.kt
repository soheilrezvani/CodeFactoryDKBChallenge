package com.srn.dkbcodechallenge.app.di

import com.srn.dkbcodechallenge.data.repository.PhotoRepositoryImpl
import com.srn.dkbcodechallenge.domain.repository.PhotoRepository
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
    fun provideCardRepository(
        impl: PhotoRepositoryImpl,
    ): PhotoRepository = impl
}
