package com.example.transitmobiletest.feature.feedsmap.view.state

import com.example.transitmobiletest.feature.feedsmap.model.data.Feed

data class FeedsMapState(
    var feeds: List<Feed> = emptyList()
)