package com.srn.shortlyappchallenge.data.datasource.local

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class ApiLocalDataSourceImpl @Inject constructor(private val apiDao: ApiDao) : ApiLocalDataSource {

    override suspend fun getShortenedApiList(): ServerResponse<List<ApiResult>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                ServerResponse.success(apiDao.getShortenedApiList())
            } catch (e: Exception) {
                ServerResponse.error(errorMessage = e.message)
            }
        }

    override suspend fun deleteApi(apiCode: String) {
        apiDao.deleteShortenedApi(apiCode)
    }

    override suspend fun saveShortenedApi(item: ApiResult) {
        apiDao.insertApi(item)
    }


}