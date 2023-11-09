package com.example.transitmobiletest.feature.feedsmap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transitmobiletest.feature.feedsmap.model.data.Feed
import com.example.transitmobiletest.feature.feedsmap.model.repo.FeedsRepository
import com.example.transitmobiletest.feature.feedsmap.view.state.SelectedFeedState
import com.example.transitmobiletest.feature.feedsmap.view.state.FeedsMapState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedsMapViewModel @Inject constructor(private val feedsRepository: FeedsRepository) : ViewModel() {
    private val _markersUiState = MutableStateFlow(FeedsMapState())
    val markersUiState: StateFlow<FeedsMapState> = _markersUiState.asStateFlow()

    private val _selectedFeedUiState = MutableStateFlow(SelectedFeedState())
    val selectedFeedUiState: StateFlow<SelectedFeedState> = _selectedFeedUiState.asStateFlow()

    init {
        viewModelScope.launch {
            feedsRepository.getFeeds().collect { feeds ->
                _markersUiState.value = FeedsMapState(feeds = feeds)
            }
        }
    }

    fun onMarkerClicked(feed: Feed) {
        _selectedFeedUiState.value = SelectedFeedState(selectedFeed = feed)
    }

    fun onMarkerDismissed() {
        _selectedFeedUiState.value = SelectedFeedState(selectedFeed = null)
    }
}