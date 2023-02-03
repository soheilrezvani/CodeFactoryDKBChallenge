package com.srn.shortlyappchallenge.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult

/**
 * Created by SoheilR .
 */
@Dao
interface ApiDao {

    @Query("SELECT * FROM ApiResult")
    suspend fun getShortenedApiList(): List<ApiResult>

    @Query("SELECT * FROM ApiResult WHERE apiCode = :apiCode")
    suspend fun getShortenedApiById(apiCode: String): ApiResult?

    @Insert(onConflict = REPLACE)
    suspend fun insertApi(item: ApiResult)

    @Query("DELETE FROM ApiResult WHERE apiCode = :apiCode")
    suspend fun deleteShortenedApi(apiCode: String)

}