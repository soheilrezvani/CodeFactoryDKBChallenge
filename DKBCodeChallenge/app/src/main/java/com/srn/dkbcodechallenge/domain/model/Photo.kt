package com.srn.dkbcodechallenge.domain.model

/**
 * Created by SoheilR .
 */
data class Photo(
    val albumId: Int = 0,
    val id: Int = 0,
    val title: String?,
    val url: String?,
    val thumbnailUrl: String?,
)