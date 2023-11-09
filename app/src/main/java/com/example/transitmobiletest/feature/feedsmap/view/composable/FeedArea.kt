package com.example.transitmobiletest.feature.feedsmap.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.transitmobiletest.feature.feedsmap.model.data.Feed
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polygon

@Composable
fun FeedArea(feed: Feed) {
    Polygon(points = listOf(
        LatLng(feed.bounds.minLat, feed.bounds.minLon),
        LatLng(feed.bounds.minLat, feed.bounds.maxLon),
        LatLng(feed.bounds.maxLat, feed.bounds.maxLon),
        LatLng(feed.bounds.maxLat, feed.bounds.minLon)
    ), fillColor = Color.Blue, strokeColor = Color.Blue, strokeWidth = 1f)
}