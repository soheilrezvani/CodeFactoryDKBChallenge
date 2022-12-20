package com.srn.dkbcodechallenge.app.di

import com.srn.dkbcodechallenge.domain.repository.PhotoRepository
import com.srn.dkbcodechallenge.domain.usecase.GetPhotoByIdUseCase
import com.srn.dkbcodechallenge.domain.usecase.PhotoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by SoheilR .
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providePhotoUseCases(repository: PhotoRepository) =
        PhotoUseCase(repository = repository)


    @Provides
    fun providePhotoByIdUserCase(repository: PhotoRepository) =
        GetPhotoByIdUseCase(repository)
}