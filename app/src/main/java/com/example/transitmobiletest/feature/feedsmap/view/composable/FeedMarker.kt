package com.example.transitmobiletest.feature.feedsmap.view

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.transitmobiletest.feature.feedsmap.model.data.Feed
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun FeedMarker(
    feed: Feed,
    icon: Bitmap,
) {
    val feedsMapViewModel: FeedsMapViewModel = viewModel()

    Marker(
        state = MarkerState(position = LatLng((feed.bounds.minLat+feed.bounds.maxLat)/2, (feed.bounds.minLon+feed.bounds.maxLon)/2)),
        title = feed.name,
        snippet = feed.name,
        icon = BitmapDescriptorFactory.fromBitmap(icon),
        onClick = { marker ->
            onMarkerClick(feedsMapViewModel, feed)
            true
        }
    )
}

fun onMarkerClick(
    feedsMapViewModel: FeedsMapViewModel,
    feed: Feed
) {
    Log.d("FeedMarker", "onMarkerClick: feed.name=${feed.name}")
    feedsMapViewModel.onMarkerClicked(feed)
}