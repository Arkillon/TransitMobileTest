package com.example.transitmobiletest.feature.feedsmap.model.repo

import com.example.transitmobiletest.feature.feedsmap.model.datasource.FeedsRemoteDataSource
import com.example.transitmobiletest.feature.feedsmap.model.data.Feed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeedsRepository @Inject constructor(
    private val dataSource: FeedsRemoteDataSource
) {
    fun getFeeds() : Flow<List<Feed>> {
        return dataSource.getFeeds
    }
}