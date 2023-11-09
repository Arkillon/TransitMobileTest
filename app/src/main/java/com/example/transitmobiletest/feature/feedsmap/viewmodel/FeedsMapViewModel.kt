package com.example.transitmobiletest.feature.feedsmap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transitmobiletest.feature.feedsmap.model.repo.FeedsRepository
import com.example.transitmobiletest.feature.feedsmap.view.state.FeedsMapState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedsMapViewModel @Inject constructor(private val feedsRepository: FeedsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(FeedsMapState())
    val uiState: StateFlow<FeedsMapState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            feedsRepository.getFeeds().collect { feeds ->
                _uiState.value = FeedsMapState(feeds = feeds)
            }
        }
    }
}