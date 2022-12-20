package com.srn.dkbcodechallenge.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.srn.dkbcodechallenge.app.presentation.screen.detail.PhotoDetailsScreen
import com.srn.dkbcodechallenge.app.presentation.screen.list.ListScreen
import com.srn.dkbcodechallenge.app.util.Constants

/**
 * Created by SoheilR .
 */

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.List.route
    ) {
        composable(route = Screen.List.route) {
            ListScreen(navController = navController)
        }
        composable(
            route = Screen.PhotoDetails.route,
            arguments = listOf(navArgument(Constants.PHOTO_DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt(Constants.PHOTO_DETAILS_ARGUMENT_KEY)
                ?.let { PhotoDetailsScreen(it, navController) }
        }
    }
}