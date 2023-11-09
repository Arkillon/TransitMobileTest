package com.example.transitmobiletest.feature.feedsmap.model.api

import retrofit2.Response
import retrofit2.http.GET

interface FeedsApi {
    @GET("feeds/static/full.json")
    suspend fun getFeeds(): Response<FeedsResponse>
}