package com.srn.shortlyappchallenge.datasource

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.data.datasource.local.ApiLocalDataSource
import com.srn.shortlyappchallenge.domain.model.ApiResult

/**
 * Created by SoheilR .
 */
class FakeLocalDataSource(var apis: MutableList<ApiResult>? = mutableListOf()): ApiLocalDataSource  {
    override suspend fun getShortenedApiList(): ServerResponse<List<ApiResult>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteApi(apiCode: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveShortenedApi(item: ApiResult) {
        TODO("Not yet implemented")
    }
}
