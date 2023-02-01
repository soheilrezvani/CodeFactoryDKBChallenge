package com.srn.shortlyappchallenge.data.api

import com.srn.shortlyappchallenge.domain.model.Api
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by SoheilR .
 */
interface ShortenApi {

    @GET("v2/shorten?")
    suspend fun getShortenApi(@Query("url") url: String): Response<Api>

}