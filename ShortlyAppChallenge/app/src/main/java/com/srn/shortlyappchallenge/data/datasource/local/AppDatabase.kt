package com.srn.shortlyappchallenge.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srn.shortlyappchallenge.domain.model.ApiResult

/**
 * Created by SoheilR .
 */
@Database(entities = [ApiResult::class] , version = 1 , exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun apiDao(): ApiDao
}