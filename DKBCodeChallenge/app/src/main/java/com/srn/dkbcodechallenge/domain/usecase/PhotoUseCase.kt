package com.srn.dkbcodechallenge.domain.usecase

import com.srn.dkbcodechallenge.data.ServerResponse
import com.srn.dkbcodechallenge.domain.model.Photo
import com.srn.dkbcodechallenge.domain.repository.PhotoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by SoheilR .
 */

@OptIn(ExperimentalCoroutinesApi::class)
class PhotoUseCase @Inject constructor(private val repository: PhotoRepository) :
    FlowUseCase<ServerResponse<List<Photo>>>() {
    override fun performAction(): Flow<ServerResponse<List<Photo>>> {
        return repository.getPhotosList()
    }
}

class GetPhotoByIdUseCase(private val photoRepository: PhotoRepository) {
    operator fun invoke(photoId: Int) = photoRepository.getPhotoById(photoId)
}