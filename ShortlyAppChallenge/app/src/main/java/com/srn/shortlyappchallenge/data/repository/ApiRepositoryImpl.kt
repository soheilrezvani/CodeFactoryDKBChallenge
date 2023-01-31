package com.srn.shortlyappchallenge.data.repository

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by SoheilR .
 */
class ApiRepositoryImpl(): ApiRepository {
    override fun shortenApi(): Flow<ServerResponse<Api>> {
        TODO("Not yet implemented")
    }
}