package com.example.testtransition.ui.feature

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtransition.ui.feature.destinations.NewDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalAnimationApi::class)
@RootNavGraph(start = true)
@Composable
@Destination
fun AnimatedVisibilityScope.Home(
    navigator: DestinationsNavigator,
) {
    val space by transition.animateDp(
        label = "spaceAnimation",
        transitionSpec = {
            spring(
                stiffness = Spring.StiffnessVeryLow,
                visibilityThreshold = Dp.VisibilityThreshold,
                dampingRatio = Spring.DampingRatioLowBouncy,
            )
        }
    ) { state ->
        when (state) {
            EnterExitState.PreEnter -> 100.dp
            EnterExitState.Visible -> 8.dp
            EnterExitState.PostExit -> 100.dp
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space, Alignment.Top),
    ) {
        val style = TextStyle.Default.copy(fontSize = 20.sp)
        Text(text = "Home", style = style)
        Text(text = "Text 1", style = style)
        Text(text = "Text 2", style = style)
        Text(text = "Text 3", style = style)
        Button(onClick = { navigator.navigate(NewDestination) }) {
            Text(text = "New", style = style)
        }
    }
}