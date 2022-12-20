package com.srn.dkbcodechallenge.app.presentation.screen.list

import com.srn.dkbcodechallenge.domain.model.Photo

/**
 * Created by SoheilR .
 */
data class PhotoListState(
    val items: List<Photo> = emptyList(),
    val isLoading: Boolean = false
)
