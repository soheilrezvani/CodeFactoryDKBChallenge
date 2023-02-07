package com.srn.shortlyappchallenge.datasource

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/**
 * Created by SoheilR .
 */
class FakeTestRepository: ApiRepository {

    private lateinit var apisServiceData : Api
    var apisDataList: LinkedHashMap<String, ApiResult> = LinkedHashMap()

    override fun getShortenedApi(url: String): Flow<ServerResponse<Api>> {
        return flow {
            emit(ServerResponse.success(apisServiceData))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun saveShortenedApi(item: ApiResult) {
        apisServiceData = Api(true , item)
        apisDataList[item.code] = item
    }

    override suspend fun deleteApi(apiCode: String) {
        apisDataList.remove(apiCode)
    }

    override suspend fun getApiList(): Flow<List<ApiResult>> {
        return flow {
            emit(apisDataList.values.toList())
        }.flowOn(Dispatchers.IO)
    }
    fun addApis(vararg items: ApiResult) {
        for (item in items) {
            apisDataList[item.code] = item
        }
    }
}