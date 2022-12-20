package com.srn.dkbcodechallenge.app.presentation.screen.detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.srn.dkbcodechallenge.app.theme.AppContentColor
import com.srn.dkbcodechallenge.app.theme.AppThemeColor

/**
 * Created by SoheilR .
 */

@Composable
fun PhotoDetailsScreen(
    photoId: Int,
    navController: NavController,
    viewModel: PhotoDetailsViewModel = hiltViewModel(),
) {
    viewModel.getPhotoDetails(photoId = photoId)
    val photoDetails by viewModel.selectedPhoto.collectAsState()

    Scaffold(
        topBar = {
            DetailsTopBar(navController = navController)
        },
        contentColor = MaterialTheme.colors.AppContentColor,
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        content = {
            photoDetails?.let { PhotoDetailsContent(it) }
        })
}

