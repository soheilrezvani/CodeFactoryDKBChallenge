package com.srn.shortlyappchallenge.domain.usecase

import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class InsertApiInDBUseCase @Inject constructor(private val repository: ApiRepository) {
    suspend operator fun invoke(item: ApiResult) = repository.saveShortenedApi(item)
}