package com.example.transitmobiletest.feature.feedsmap.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel


@Composable
fun FeedsMapScreen(
) {
    val feedsMapViewModel: FeedsMapViewModel = viewModel()
    val bottomSheetUiState by feedsMapViewModel.selectedFeedUiState.collectAsState()

    FeedsGoogleMap()

    bottomSheetUiState.selectedFeed?.let {
        FeedBottomSheet()
    }
}