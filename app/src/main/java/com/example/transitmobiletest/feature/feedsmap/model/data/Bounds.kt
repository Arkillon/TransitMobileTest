package com.example.transitmobiletest.feature.feedsmap.model.data

import com.google.gson.annotations.SerializedName
class Bounds(@SerializedName("max_lat") val maxLat: Double,
              @SerializedName("max_lon") val maxLon: Double,
              @SerializedName("min_lat") val minLat: Double,
              @SerializedName("min_lon") val minLon: Double,
              )