package com.example.transitmobiletest.feature.feedsmap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ResourceType")
@Composable
fun FeedBottomSheet() {
    val feedsMapViewModel: FeedsMapViewModel = viewModel()
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    feedsMapViewModel.selectedFeedUiState.value.selectedFeed?.let { feed ->
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                scope.launch {
                    feedsMapViewModel.onMarkerDismissed()
                    sheetState.hide()
                }
            },
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                CenterAlignedTopAppBar(title = { Text("Information on the feed") })
            }
            Box {
                Column() {
                    FeedBottomSheetText(feed.name)
                    FeedBottomSheetText("${feed.location}, ${feed.subCountryCodes}, ${feed.countryCodes}")
                    FeedBottomSheetText("Feed quality: ${feed.stars}")
                    FeedBottomSheetText("Last update: ${feed.uploadedAt}")
                }
            }
        }
    }
}