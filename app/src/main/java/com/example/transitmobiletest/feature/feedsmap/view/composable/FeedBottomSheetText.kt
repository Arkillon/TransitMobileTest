package com.example.transitmobiletest.feature.feedsmap.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FeedBottomSheetText(text: String) {
    Row(modifier = Modifier.padding(12.dp)) {
        Text(text)
    }
}