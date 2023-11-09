package com.example.transitmobiletest.feature.feedsmap.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FeedBottomSheetText(text: String) {
    Box {
        Row() {
            Text(text)
        }
    }
}