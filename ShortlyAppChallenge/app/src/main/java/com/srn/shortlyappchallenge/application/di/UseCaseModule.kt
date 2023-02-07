package com.srn.shortlyappchallenge.application.di

import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import com.srn.shortlyappchallenge.domain.usecase.DeleteApiUseCase
import com.srn.shortlyappchallenge.domain.usecase.GetApiListFromDBUseCase
import com.srn.shortlyappchallenge.domain.usecase.InsertApiInDBUseCase
import com.srn.shortlyappchallenge.domain.usecase.ShortenApiUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by SoheilR .
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideShortenApiUseCase(repository: ApiRepository) =
        ShortenApiUseCase(repository)

    @Provides
    fun provideInsertApiInDBUseCase(repository: ApiRepository) =
        InsertApiInDBUseCase(repository)

    @Provides
    fun provideDeleteApiUseCase(repository: ApiRepository) =
        DeleteApiUseCase(repository)

    @Provides
    fun provideGetSavedApisFromDbUseCase(repository: ApiRepository) =
        GetApiListFromDBUseCase(repository)
}