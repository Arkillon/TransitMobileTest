package com.example.transitmobiletest.feature.feedsmap.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.transitmobiletest.feature.feedsmap.viewmodel.FeedsMapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedsMapActivity : ComponentActivity() {
    private lateinit var viewModel: FeedsMapViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FeedsMapViewModel::class.java]

        setContent {
            FeedsMapScreen(viewModel)
        }
    }
}