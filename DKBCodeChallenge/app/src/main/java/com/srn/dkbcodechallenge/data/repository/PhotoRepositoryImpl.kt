package com.srn.dkbcodechallenge.data.repository

import com.srn.dkbcodechallenge.data.ServerResponse
import com.srn.dkbcodechallenge.data.datasource.PhotoRemoteDataSource
import com.srn.dkbcodechallenge.domain.model.Photo
import com.srn.dkbcodechallenge.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class PhotoRepositoryImpl @Inject constructor(
    private val photoRemoteDataSource: PhotoRemoteDataSource,
) : PhotoRepository {
    override fun getPhotosList(): Flow<ServerResponse<List<Photo>>> {
        return flow {
            emit(ServerResponse.loading())
            val result = photoRemoteDataSource.getPhotosList()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override fun getPhotoById(id: Int): Flow<ServerResponse<Photo>> {
        return flow {
            emit(ServerResponse.loading())
            val result = photoRemoteDataSource.getPhotoById(id)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}