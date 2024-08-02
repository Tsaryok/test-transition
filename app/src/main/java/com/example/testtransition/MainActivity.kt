package com.example.testtransition

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testtransition.ui.feature.appDestination
import com.example.testtransition.ui.feature.destinations.NewDestination
import com.example.testtransition.ui.theme.TestTransitionTheme
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: View = FrameLayout(this)
        view.setBackgroundColor(android.graphics.Color.BLUE)
        val params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        view.layoutParams = params
        setContentView(view)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTransitionTheme {
        Greeting("Android")
    }
}

private fun getDefaultTransitionAnimation() = RootNavGraphDefaultAnimations(
    enterTransition = {
        when (targetState.appDestination()) {
            NewDestination -> slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                spring(
                    stiffness = Spring.StiffnessVeryLow,
                    dampingRatio = Spring.DampingRatioLowBouncy,
                ),
            )

            else -> EnterTransition.None
        }
    },
    exitTransition = {
        when (targetState.appDestination()) {
            NewDestination -> slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                spring(
                    stiffness = Spring.StiffnessVeryLow,
                    dampingRatio = Spring.DampingRatioLowBouncy,
                ),
            )

            else -> ExitTransition.None
        }
    },
    popEnterTransition = {
        when (initialState.appDestination()) {
            NewDestination -> slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                spring(
                    stiffness = Spring.StiffnessVeryLow,
                    dampingRatio = Spring.DampingRatioLowBouncy,
                ),
            )

            else -> EnterTransition.None
        }
    },
    popExitTransition = {
        when (initialState.appDestination()) {
            NewDestination -> slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                spring(
                    stiffness = Spring.StiffnessVeryLow,
                    dampingRatio = Spring.DampingRatioLowBouncy,
                ),
            )

            else -> ExitTransition.None
        }
    },
)