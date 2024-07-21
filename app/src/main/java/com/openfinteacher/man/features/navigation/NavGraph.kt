package com.openfinteacher.man.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.openfinteacher.man.features.manual.ManualScreen
import com.openfinteacher.man.features.open.OpenScreen
import com.openfinteacher.man.features.quize.QuizView
import com.openfinteacher.man.features.start.StartScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier) {

    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = Screens.OPEN) {

        composable(Screens.OPEN){
            OpenScreen(modifier){
                navigator.navigate(Screens.START)
            }
        }

        composable(Screens.START) {
            StartScreen(modifier,

                onQuiz = { index -> navigator.navigate("${Screens.QUIZ}/$index") },
                onManual = { index -> navigator.navigate("${Screens.MANUAL}/$index") }
            )
        }

        composable("${Screens.MANUAL}/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0

            ManualScreen(
                modifier = modifier,
                index = index,
                onBack = {navigator.navigateUp()},
                onQuiz = { navigator.navigate("${Screens.QUIZ}/$index") },
                onComplete = {
                    navigator.navigate(Screens.START) {
                        popUpTo(navigator.graph.id) {
                            this.inclusive = true
                        }
                    }
                }
            )
        }

        composable("${Screens.QUIZ}/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
            QuizView(
                modifier = modifier,
                index = index,
                onComplete = { navigator.navigateUp() }
            )
        }

    }
}