package com.srn.dkbcodechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.srn.dkbcodechallenge.app.presentation.navigation.NavGraph
import com.srn.dkbcodechallenge.app.theme.DKBCodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DKBCodeChallengeTheme() {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}