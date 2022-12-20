package com.srn.dkbcodechallenge.app.presentation.navigation

/**
 * Created by SoheilR .
 */
sealed class Screen(val route: String) {
    object List : Screen("list_screen")
    object PhotoDetails : Screen("photo_details_screen/{photoId}") {
        fun passPhotoId(id: Int) = "photo_details_screen/$id"
    }
}
