package com.example.transitmobiletest.feature.feedsmap.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.transitmobiletest.R
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel
import com.example.transitmobiletest.util.ColorUtils.getColorCodeFromCountryCode
import com.example.transitmobiletest.util.toBitmap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun FeedsGoogleMap(
) {
    val feedsMapViewModel: FeedsMapViewModel = viewModel()
    val feedsMapUiState by feedsMapViewModel.markersUiState.collectAsState()
//    val selectedFeedUiState by feedsMapViewModel.selectedFeedUiState.collectAsState()

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = CameraPositionState(position = CameraPosition(LatLng(45.508888, -73.561668), 10f, 0f, 0f))
    ) {
        feedsMapUiState.feeds.forEach { feed ->
            R.drawable.pin.toBitmap(LocalContext.current,getColorCodeFromCountryCode(feed.countryCodes))?.let { bitmap->
                FeedMarker(feed, bitmap)
            }
        }

        //TODO optimize pin bitmaps in LruCache to fix feed area lagging
//        selectedFeedUiState.selectedFeed?.let { selectedFeed ->
//            FeedArea(selectedFeed)
//        }
    }
}