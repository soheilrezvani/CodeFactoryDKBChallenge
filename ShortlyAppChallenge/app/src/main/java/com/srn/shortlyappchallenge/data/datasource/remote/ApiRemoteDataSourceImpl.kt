package com.srn.shortlyappchallenge.data.datasource.remote

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.data.api.ShortenApi
import com.srn.shortlyappchallenge.data.base.getResult
import com.srn.shortlyappchallenge.domain.model.Api
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class ApiRemoteDataSourceImpl @Inject constructor(
    private val shortenApi: ShortenApi
): ApiRemoteDataSource {
    override suspend fun getShortenedApi(url: String): ServerResponse<Api> {
        return getResult { shortenApi.getShortenApi(url)}
    }
}