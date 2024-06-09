package com.example.gymbro.ui.theme.model

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymbro.ui.theme.view.AchivementsScreen
import com.example.gymbro.ui.theme.view.AddExercisesToTrainingScreen
import com.example.gymbro.ui.theme.view.AddTrainingScreen
import com.example.gymbro.ui.theme.view.LibraryScreen
import com.example.gymbro.ui.theme.view.MainScreenBack
import com.example.gymbro.ui.theme.view.MainScreenFront
import com.example.gymbro.ui.theme.view.MuscleTraindedScreen
import com.example.gymbro.ui.theme.view.StatsScreen
import com.example.gymbro.ui.theme.view.TrainingListScreen


sealed class Screens(val route: String) {
    object AchivementsScreen : Screens("achivements")
    object AddExercisesToTrainingScreen : Screens("add_exercises")
    object AddTrainingScreen : Screens("add_training")
    object LibraryScreen : Screens("library")
    object MainScreenBack : Screens("main_back")
    object MainScreenFront : Screens("main_front")
    object MuscleTrainedScreen : Screens("muscle_trained")
    object StatsScreen : Screens("stats")
    object TrainingListScreen : Screens("trainings")

}

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    //object Home : BottomBar(Screens.ProductListScreen.route, "Fridge", Icons.Default.Home)
    //object First : BottomBar(Screens.HistoryScreen.route, "History", Icons.Default.Info)
    object Left : BottomBar(Screens.LibraryScreen.route, "Library", Icons.Default.Build)
    object Leftm : BottomBar(Screens.TrainingListScreen.route, "Trainings", Icons.Default.Menu)
    object Middle : BottomBar(Screens.MainScreenFront.route, "Main", Icons.Default.Home)
    object Rightm : BottomBar(Screens.StatsScreen.route, "Stats", Icons.Default.List)
    object Right : BottomBar(Screens.AchivementsScreen.route, "Trophies", Icons.Default.Favorite)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomMenu(navController = navController)},
        content = { BottomNavGraph(navController = navController, bottomPadding = it.calculateBottomPadding()) }
    )
}

@Composable
fun BottomNavGraph(navController: NavHostController, bottomPadding: Dp){
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreenFront.route

    ) {
        composable(route = Screens.AchivementsScreen.route){ MainScreenBack() }
        composable(route = Screens.StatsScreen.route){ StatsScreen() }
        composable(route = Screens.MainScreenFront.route){ MainScreenFront() }
        composable(route = Screens.LibraryScreen.route){ LibraryScreen() }
        composable(route = Screens.AddTrainingScreen.route){ AddTrainingScreen() }
        composable(route = Screens.AddExercisesToTrainingScreen.route){ AddExercisesToTrainingScreen() }
        composable(route = Screens.MainScreenBack.route){ MainScreenBack() }
        composable(route = Screens.MuscleTrainedScreen.route){ MuscleTraindedScreen() }
        composable(route = Screens.TrainingListScreen.route){ TrainingListScreen() }
    }
}

@Composable
fun BottomMenu(navController: NavHostController){
    val screens = listOf(
        BottomBar.Left, BottomBar.Leftm, BottomBar.Middle, BottomBar.Rightm, BottomBar.Right
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar{
        screens.forEach{screen ->
            NavigationBarItem(
                label = { Text(text = screen.title)},
                icon = {Icon(imageVector = screen.icon, contentDescription = "icon")},
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {navController.navigate(screen.route)}
            )
        }
    }
}