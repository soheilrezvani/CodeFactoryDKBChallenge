package com.srn.shortlyappchallenge.data.repository

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.data.datasource.ApiRemoteDataSource
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class ApiRepositoryImpl @Inject constructor(
    private val remoteDataSource: ApiRemoteDataSource,
) : ApiRepository {
    override fun getShortenedApi(url: String): Flow<ServerResponse<Api>> {
        return flow {
            emit(ServerResponse.loading())
            val result = remoteDataSource.getShortenedApi(url)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}