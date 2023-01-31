package com.srn.shortlyappchallenge.domain.repository

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.domain.model.Api
import kotlinx.coroutines.flow.Flow

/**
 * Created by SoheilR .
 */
interface ApiRepository {
    fun shortenApi(): Flow<ServerResponse<Api>>
}