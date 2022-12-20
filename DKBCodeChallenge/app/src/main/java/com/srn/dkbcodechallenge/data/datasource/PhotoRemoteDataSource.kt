package com.srn.dkbcodechallenge.data.datasource

import com.srn.dkbcodechallenge.data.ServerResponse
import com.srn.dkbcodechallenge.domain.model.Photo

/**
 * Created by SoheilR .
 */
interface PhotoRemoteDataSource {
    suspend fun getPhotosList(): ServerResponse<List<Photo>>

    suspend fun getPhotoById(photoId: Int): ServerResponse<Photo>
}