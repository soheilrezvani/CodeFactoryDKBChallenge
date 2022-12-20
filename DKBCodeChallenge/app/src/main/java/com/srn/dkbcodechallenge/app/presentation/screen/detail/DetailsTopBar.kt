package com.srn.dkbcodechallenge.app.presentation.screen.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.srn.dkbcodechallenge.R
import com.srn.dkbcodechallenge.app.theme.AppContentColor
import com.srn.dkbcodechallenge.app.theme.AppThemeColor

/**
 * Created by SoheilR .
 */
@Composable
fun DetailsTopBar(
    navController: NavController,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back_icon),
                    tint = MaterialTheme.colors.AppContentColor
                )
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.details_page),
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
        },
        elevation = 8.dp,
    )
}