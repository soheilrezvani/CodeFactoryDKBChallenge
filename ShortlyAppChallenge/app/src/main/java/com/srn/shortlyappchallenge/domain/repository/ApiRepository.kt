package com.srn.shortlyappchallenge.domain.repository

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by SoheilR .
 */
interface ApiRepository {
    fun getShortenedApi(url: String): Flow<ServerResponse<Api>>

    suspend fun saveShortenedApi(item: ApiResult)

    suspend fun deleteApi(apiCode: String)

    suspend fun getApiList(): Flow<List<ApiResult>>
}