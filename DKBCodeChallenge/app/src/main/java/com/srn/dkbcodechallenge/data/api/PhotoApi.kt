package com.srn.dkbcodechallenge.data.api

import com.srn.dkbcodechallenge.domain.model.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by SoheilR .
 */
interface PhotoApi {
    @GET("photos")
    suspend fun getPhotosList(): Response<List<Photo>>

    @GET("photos/{id}")
    suspend fun getPhotoById(@Path("id") photoId: Int): Response<Photo>

}