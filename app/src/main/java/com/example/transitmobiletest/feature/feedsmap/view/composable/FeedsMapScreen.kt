package com.example.transitmobiletest.feature.feedsmap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.transitmobiletest.R
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel
import com.example.transitmobiletest.util.ColorUtils.getColorCodeFromCountryCode
import com.example.transitmobiletest.util.toBitmap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@SuppressLint("ResourceType")
@Composable
fun FeedsMapScreen(
    feedsMapViewModel: FeedsMapViewModel
) {
    val feedsMapUiState by feedsMapViewModel.uiState.collectAsState()

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = CameraPositionState(position = CameraPosition(LatLng(45.508888, -73.561668), 10f, 0f, 0f))
    ) {
        feedsMapUiState.feeds.forEach { feed ->
            R.drawable.pin.toBitmap(LocalContext.current,getColorCodeFromCountryCode(feed.countryCodes))?.let { bitmap->
                //TODO add Polygon to show the area covered by the feed
//                Polygon(points = listOf(
//                    LatLng(feed.bounds.minLat, feed.bounds.minLon),
//                    LatLng(feed.bounds.minLat, feed.bounds.maxLon),
//                    LatLng(feed.bounds.maxLat, feed.bounds.maxLon),
//                    LatLng(feed.bounds.maxLat, feed.bounds.minLon)
//                ), fillColor =  Color(getColorCodeFromCountryCode(feed.countryCodes)), strokeColor = Color(getColorCodeFromCountryCode(feed.countryCodes)), strokeWidth = 1f)
                FeedMarker(feed, bitmap)
            }
        }
    }
}