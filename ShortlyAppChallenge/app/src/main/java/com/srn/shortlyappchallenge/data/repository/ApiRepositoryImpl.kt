package com.srn.shortlyappchallenge.data.repository

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.data.datasource.local.ApiLocalDataSource
import com.srn.shortlyappchallenge.data.datasource.remote.ApiRemoteDataSource
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class ApiRepositoryImpl @Inject constructor(
    private val remoteDataSource: ApiRemoteDataSource,
    private val localDataSource: ApiLocalDataSource,
) : ApiRepository {


    override fun getShortenedApi(url: String): Flow<ServerResponse<Api>> {
        return flow {
            emit(ServerResponse.loading())
            val result = remoteDataSource.getShortenedApi(url)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun saveShortenedApi(item: ApiResult) {
        coroutineScope {
            localDataSource.saveShortenedApi(item)
        }
    }

    override suspend fun deleteApi(apiCode: String) {
        coroutineScope {
            localDataSource.deleteApi(apiCode)
        }
    }

    override suspend fun getApiList(): Flow<List<ApiResult>> {
        return flow {

            val result = localDataSource.getShortenedApiList()
            if (result.data != null) {
                emit(result.data)
            } else
                emit(emptyList())

        }.flowOn(Dispatchers.IO)
    }

}