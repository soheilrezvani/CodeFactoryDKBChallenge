package com.srn.shortlyappchallenge.data.datasource.local

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult

/**
 * Created by SoheilR .
 */
interface ApiLocalDataSource {

    suspend fun getShortenedApiList(): ServerResponse<List<ApiResult>>

    suspend fun deleteApi(apiCode: String)

    suspend fun saveShortenedApi(item: ApiResult)
}