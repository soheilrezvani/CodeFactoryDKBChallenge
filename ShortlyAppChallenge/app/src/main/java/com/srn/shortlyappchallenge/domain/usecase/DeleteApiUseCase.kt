package com.srn.shortlyappchallenge.domain.usecase

import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class DeleteApiUseCase @Inject constructor(private val repository: ApiRepository) {
    suspend operator fun invoke(apiCode: String) = repository.deleteApi(apiCode)
}