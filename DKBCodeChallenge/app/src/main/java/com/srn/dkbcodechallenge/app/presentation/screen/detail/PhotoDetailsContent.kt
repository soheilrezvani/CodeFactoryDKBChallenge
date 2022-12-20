package com.srn.dkbcodechallenge.app.presentation.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.srn.dkbcodechallenge.app.theme.AppThemeColor
import com.srn.dkbcodechallenge.domain.model.Photo

/**
 * Created by SoheilR .
 */
@Composable
fun PhotoDetailsContent(photo: Photo) {
    val scrollState = rememberScrollState()
    Card(
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.AppThemeColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current)
                    .data(data = photo.url).apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                        scale(Scale.FIT)
                    }).build()),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                photo.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}