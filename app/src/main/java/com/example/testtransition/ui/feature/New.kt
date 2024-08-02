package com.example.testtransition.ui.feature

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Destination
fun AnimatedVisibilityScope.New() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
            //.animateEnterExit(),
        contentAlignment = Alignment.Center,
    ) {
        val style = TextStyle.Default.copy(fontSize = 20.sp)
        Text(text = "New", style = style)
    }
}