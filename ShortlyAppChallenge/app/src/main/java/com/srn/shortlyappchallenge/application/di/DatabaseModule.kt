package com.srn.shortlyappchallenge.application.di

import android.content.Context
import androidx.room.Room
import com.srn.shortlyappchallenge.data.datasource.local.ApiDao
import com.srn.shortlyappchallenge.data.datasource.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by SoheilR .
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideApiDao(appDatabase: AppDatabase): ApiDao {
        return appDatabase.apiDao()
    }

    @Provides
    @Singleton
    fun provideApiDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase {
        return Room
            .databaseBuilder(appContext , AppDatabase::class.java, "Apis.db")
            .build()
    }

}