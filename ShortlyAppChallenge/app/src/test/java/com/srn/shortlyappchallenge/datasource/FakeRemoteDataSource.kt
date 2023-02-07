package com.srn.shortlyappchallenge.datasource

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.data.datasource.remote.ApiRemoteDataSource
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult

/**
 * Created by SoheilR .
 */
class FakeRemoteDataSource(var apis: MutableList<ApiResult>? = mutableListOf()) : ApiRemoteDataSource {
    override suspend fun getShortenedApi(url: String): ServerResponse<Api> {
        TODO("Not yet implemented")
    }
}