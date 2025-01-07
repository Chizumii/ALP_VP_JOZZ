package com.example.alp_vp_jozz

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.core.view.WindowCompat
//import com.example.alp_vp_jozz.ui.theme.ALP_VP_JOZZTheme
//import com.example.alp_vp_jozz.view.LoginScreen
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        // Enable edge-to-edge
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        setContent {
//            ALP_VP_JOZZTheme {
//                LoginScreen(
//                    userViewModel = TODO(),
//                    onLoginSuccess = TODO()
//                )
//            }
//        }
//    }
//}
// MainActivity.kt
//package com.example.alp_vp_jozz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.alp_vp_jozz.ui.theme.ALP_VP_JOZZTheme
import com.example.alp_vp_jozz.view.TournamentDetailView
import com.example.alp_vp_jozz.view.TournamentTeamSubmit
import com.example.alp_vp_jozz.view.TournamentView
import com.example.alp_vp_jozz.view.templates.TorunamentCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ALP_VP_JOZZTheme(){
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tournamentView") {
        // Tournament View Route
        composable("tournamentView") {
            TournamentView(
                onCardClick = { name_tournament ->
                    navController.navigate("tournamentDetail/$name_tournament")
                }
            )
        }

        // Tournament Detail Route with Argument
        composable(
            "tournamentDetail/{tournamentId}",
            arguments = listOf(navArgument("tournamentId") { type = NavType.StringType })
        ) { backStackEntry ->
            val tournamentId = backStackEntry.arguments?.getString("tournamentId")
            TournamentDetailView(
                name_tournament = tournamentId,
                onRegisterClick = {
                    navController.navigate("tournamentSubmit/$tournamentId")
                }
            )
        }

        // Tournament Submit Route with Argument
        composable(
            "tournamentSubmit/{tournamentId}",
            arguments = listOf(navArgument("tournamentId") { type = NavType.StringType })
        ) { backStackEntry ->
            val tournamentId = backStackEntry.arguments?.getString("tournamentId")
            TournamentTeamSubmit(
                tournamentId = tournamentId,
                onSubmit = {
                    // Handle post-submission actions, e.g., navigate back or show confirmation
                    navController.popBackStack("tournamentView", inclusive = false)
                }
            )
        }
    }
}


