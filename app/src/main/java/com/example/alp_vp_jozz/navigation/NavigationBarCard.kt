package com.example.alp_vp_jozz.navigation

import ProfileScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.alp_vp_jozz.R
import com.example.alp_vp_jozz.view.NewsScreen
import com.example.alp_vp_jozz.view.TeamScreen
import com.example.alp_vp_jozz.view.TournamentView
import com.example.alp_vp_jozz.view.Welcomestart
import com.example.alp_vp_jozz.viewmodels.TournamentViewModel

@Composable
fun MainScreen(navController: NavHostController, restaurantViewModel: TournamentViewModel) {
    val bottomNavRoutes = listOf("Home", "News", "Tournament", "Team", "Profile")
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    // Scaffold untuk mengelola struktur layar
    Scaffold(
        bottomBar = {
            // Tampilkan BottomNavigationBar hanya jika rute saat ini ada di bottomNavRoutes
            if (currentRoute in bottomNavRoutes) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            restaurantViewModel
        )
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf("Home", "News", "Tournament", "Team", "Profile")
    val icons = listOf(
        R.drawable.baseline_home_filled_24,
        R.drawable.baseline_search_24,
        R.drawable.champion,
        R.drawable.baseline_groups_24,
        R.drawable.baseline_person_24
    )

    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar (){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item) // Navigate to selected page
                },
                icon = {
                    Icon(
                        painter = painterResource(id = icons[index]),
                        contentDescription = item
                    )
                },
                label = {
                    Text(
                        text = item,
                    )
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier, tournamentViewModel: TournamentViewModel) {
    NavHost(
        navController = navController,
        startDestination = "Home",
        modifier = modifier
    ) {
//        composable("Home") { Welcomestart(navController = navController, tournamentViewModel, context = LocalContext.current) }
//        composable("News") { NewsScreen(navController = navController) }
        composable("Tournament") { TournamentView(navController = navController, tournamentViewModel) }
//        composable("Team") { TeamScreen(navController = navController) }
//        composable("Profile") { ProfileScreen(navController = navController, tournamentViewModel) }
    }
}