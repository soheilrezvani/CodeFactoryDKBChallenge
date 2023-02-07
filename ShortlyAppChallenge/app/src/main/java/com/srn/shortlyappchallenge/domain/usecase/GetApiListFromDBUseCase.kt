package com.srn.shortlyappchallenge.domain.usecase

import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class GetApiListFromDBUseCase @Inject constructor(private val repository: ApiRepository) {
    suspend operator fun invoke() = repository.getApiList()
}