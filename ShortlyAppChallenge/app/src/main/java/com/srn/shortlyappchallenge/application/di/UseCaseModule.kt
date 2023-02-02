package com.srn.shortlyappchallenge.application.di

import com.srn.shortlyappchallenge.domain.repository.ApiRepository
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
}