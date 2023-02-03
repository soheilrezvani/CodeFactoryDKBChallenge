package com.srn.shortlyappchallenge.data.datasource.remote

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.Api

/**
 * Created by SoheilR .
 */
interface ApiRemoteDataSource {
    suspend fun getShortenedApi(url: String): ServerResponse<Api>
}