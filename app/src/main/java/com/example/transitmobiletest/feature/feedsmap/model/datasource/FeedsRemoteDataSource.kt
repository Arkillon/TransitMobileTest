package com.example.transitmobiletest.feature.feedsmap.model.datasource

import com.example.transitmobiletest.feature.feedsmap.model.api.FeedsApi
import com.example.transitmobiletest.feature.feedsmap.model.data.Feed
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ActivityRetainedScoped
class FeedsRemoteDataSource @Inject constructor(
    private val feedsApi: FeedsApi
) {
    val getFeeds: Flow<List<Feed>> = flow {
        feedsApi.getFeeds().body()?.let {
            emit(it.feeds)
        }
    }
}