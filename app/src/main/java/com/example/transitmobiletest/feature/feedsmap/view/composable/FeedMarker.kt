package com.example.transitmobiletest.feature.feedsmap.view

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import com.example.transitmobiletest.feature.feedsmap.model.data.Feed
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun FeedMarker(
    feed: Feed,
    icon: Bitmap
) {
    Marker(
        state = MarkerState(position = LatLng((feed.bounds.minLat+feed.bounds.maxLat)/2, (feed.bounds.minLon+feed.bounds.maxLon)/2)),
        title = feed.name,
        snippet = feed.name,
        icon = BitmapDescriptorFactory.fromBitmap(icon),
//        onClick = {
//        //TODO show bottom sheet
//        }
    )
}
