package com.srn.dkbcodechallenge.data.datasource

import com.srn.dkbcodechallenge.data.ServerResponse
import com.srn.dkbcodechallenge.data.api.PhotoApi
import com.srn.dkbcodechallenge.data.base.getResult
import com.srn.dkbcodechallenge.domain.model.Photo
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class PhotoRemoteDataSourceImpl @Inject constructor(
    private val photoApi: PhotoApi,
) : PhotoRemoteDataSource {

    override suspend fun getPhotosList(): ServerResponse<List<Photo>> {
        return getResult { photoApi.getPhotosList() }
    }

    override suspend fun getPhotoById(photoId: Int): ServerResponse<Photo> {
       return getResult { photoApi.getPhotoById(photoId) }
    }
}