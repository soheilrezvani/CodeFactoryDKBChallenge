package com.srn.dkbcodechallenge.app.presentation.screen.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.srn.dkbcodechallenge.app.presentation.navigation.Screen
import com.srn.dkbcodechallenge.app.theme.ItemBackgroundColor
import com.srn.dkbcodechallenge.domain.model.Photo

/**
 * Created by SoheilR .
 */
@Composable
fun PhotoListContent(allPhotos: List<Photo>, navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(
            items = allPhotos,
            key = { item ->
                item.id
            }
        ) { item ->
            PhotoListItem(photo = item, navController = navController)
        }
    }

}

@Composable
fun PhotoListItem(photo: Photo, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .height(120.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.ItemBackgroundColor
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
                .clickable {
                    navController.navigate(route = Screen.PhotoDetails.passPhotoId(photo.id))
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            photo.thumbnailUrl?.let {
                Image(
                    modifier = Modifier
                        .padding(
                            end = 4.dp,
                        )
                        .width(100.dp),
                    painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current)
                        .data(data = photo.thumbnailUrl).apply(block = fun ImageRequest.Builder.() {
                            scale(Scale.FILL)
                        }).build()),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
            Column(Modifier
                .height(IntrinsicSize.Max)
                .padding(
                    end = 2.dp,
                )) {
                photo.title?.let { Text(text = it, style = MaterialTheme.typography.body1) }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = photo.albumId.toString(), style = MaterialTheme.typography.body2)
            }
        }
    }
}