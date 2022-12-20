package com.srn.dkbcodechallenge.domain.repository

import com.srn.dkbcodechallenge.data.ServerResponse
import com.srn.dkbcodechallenge.domain.model.Photo
import kotlinx.coroutines.flow.Flow

/**
 * Created by SoheilR .
 */
interface PhotoRepository {
    fun getPhotosList(): Flow<ServerResponse<List<Photo>>>
    fun getPhotoById(id: Int): Flow<ServerResponse<Photo>>
}