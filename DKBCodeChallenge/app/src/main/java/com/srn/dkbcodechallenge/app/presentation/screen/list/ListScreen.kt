package com.srn.dkbcodechallenge.app.presentation.screen.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.srn.dkbcodechallenge.app.theme.AppContentColor
import com.srn.dkbcodechallenge.app.theme.AppThemeColor

/**
 * Created by SoheilR .
 */
@Composable
fun ListScreen(navController: NavHostController, viewModel: ListViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    viewModel.getData()

    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,

        topBar = {
            TopBar()
        },
        content = {
            PhotoListContent(allPhotos = state.items, navController = navController)
        }
    )
}