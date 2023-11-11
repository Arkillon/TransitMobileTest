package com.example.transitmobiletest.feature.feedsmap.model.data

import com.google.gson.annotations.SerializedName
class Feed(@SerializedName("feed_id") val id: Int,
           @SerializedName("feed_name") val name: String,
           @SerializedName("feed_location") val location: String,
           @SerializedName("sub_country_codes") val subCountryCodes: String,
           @SerializedName("country_codes") val countryCodes: String,
           @SerializedName("stars") val stars: Int,
           @SerializedName("bgtfs_uploaded_at") val uploadedAt: String?,
           @SerializedName("bounds") val bounds: Bounds,
)