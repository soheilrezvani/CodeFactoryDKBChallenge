package com.srn.shortlyappchallenge.domain.usecase

import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
class ShortenApiUseCase @Inject constructor(private val repository: ApiRepository) {
    operator fun invoke(url: String) = repository.getShortenedApi(url)
}