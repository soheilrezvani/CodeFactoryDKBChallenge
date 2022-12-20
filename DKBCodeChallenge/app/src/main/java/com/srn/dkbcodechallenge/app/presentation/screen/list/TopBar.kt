package com.srn.dkbcodechallenge.app.presentation.screen.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.srn.dkbcodechallenge.R
import com.srn.dkbcodechallenge.app.theme.AppContentColor
import com.srn.dkbcodechallenge.app.theme.AppThemeColor

/**
 * Created by SoheilR .
 */
@Composable
fun TopBar(
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        title = {
            Text(
                text = stringResource(R.string.photo_list),
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = 0.dp,
    )
}

