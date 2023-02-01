package com.srn.shortlyappchallenge.data.api

import com.srn.shortlyappchallenge.domain.model.Api
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by SoheilR .
 */
interface ShortenApi {
    @GET("v2/shorten?{url}")
    suspend fun getShortenApi(@Path("url") url: String): Response<Api>

//    https://api.shrtco.de/v2/shorten?url=example.org/very/long/link.html
}