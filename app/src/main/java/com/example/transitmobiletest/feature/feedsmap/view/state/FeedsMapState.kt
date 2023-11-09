package com.example.transitmobiletest.feature.feedsmap.view.state

import com.example.transitmobiletest.feature.feedsmap.model.data.Feed

data class FeedsMapState(
    val feeds: List<Feed> = emptyList(),
    val selectedFeed: Feed? = null,
)