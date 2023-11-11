package com.example.transitmobiletest.feature.feedsmap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.transitmobiletest.R
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel
import com.example.transitmobiletest.util.DateTimeUtils.getFormattedDateTime
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
                CenterAlignedTopAppBar(title = { Text(feed.name) })
            }
            Column(modifier = Modifier.padding(bottom = 30.dp)) {
                FeedBottomSheetText("${feed.location}, ${feed.subCountryCodes}, ${feed.countryCodes}")
                FeedBottomSheetText(stringResource(R.string.feed_map_bottom_sheet_stars_label) + " ${feed.stars}")
                FeedBottomSheetText(stringResource(R.string.feed_map_bottom_sheet_last_update_label) + " ${getFormattedDateTime(feed.uploadedAt)}")
                FeedBottomSheetText(stringResource(R.string.feed_map_bottom_sheet_last_max_lat_label) + " ${feed.bounds.maxLat}")
                FeedBottomSheetText(stringResource(R.string.feed_map_bottom_sheet_last_max_lon_label) + " ${feed.bounds.maxLon}")
                FeedBottomSheetText(stringResource(R.string.feed_map_bottom_sheet_last_min_lat_label) + " ${feed.bounds.minLat}")
                FeedBottomSheetText(stringResource(R.string.feed_map_bottom_sheet_last_min_lon_label) + " ${feed.bounds.minLon}")
            }
        }
    }
}