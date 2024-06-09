package com.example.gymbro.ui.theme.view

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.gymbro.ui.theme.LightGreen
import com.example.gymbro.ui.theme.Purple40
import com.example.gymbro.ui.theme.model.Screens
import com.example.gymbro.ui.theme.viewModel.ExerciseViewModel
import com.example.gymbro.ui.theme.viewModel.ExerciseViewModelFactory

@Composable
fun LibraryScreen(navController: NavHostController, bottomPadding: Dp){
    val viewModelExercise: ExerciseViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModelExercise",
        ExerciseViewModelFactory(LocalContext.current.applicationContext as Application)
    )

    val exerciseElements by viewModelExercise.usersState.collectAsStateWithLifecycle()

    Scaffold ( modifier = Modifier.padding(bottom = bottomPadding),
        floatingActionButton = {
            FloatingActionButton( modifier = Modifier.clickable{},
                onClick = {
                    navController.navigate(Screens.AddExerciseFront.route)
                },
                containerColor = LightGreen
            ) {
               Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            ) {
                LazyColumn (modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)

                ) {
                    items(exerciseElements.size) {
                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(Color.LightGray)
                            .clickable {
                                navController.navigate(Screens.AddExerciseFront.route)
                            }
                        )
                        {
                            Text(text = exerciseElements[it].nazwa)
                        }
                    }
                }
            }
        }
    )
}