package com.example.gymbro.ui.theme.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background

import android.app.Application

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymbro.ui.theme.model.AchiveElement
import com.example.gymbro.ui.theme.viewModel.AchiveViewModel
import com.example.gymbro.ui.theme.viewModel.AchiveViewModelFactory


data class Achievement(
    val title: String,
    val description: String,
    val progress: Int
)



@Composable
fun AchivementsScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val viewModelAchivements: AchiveViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModelAchivements",
        AchiveViewModelFactory(LocalContext.current.applicationContext as Application)
    )


    /*val achievements = listOf(
        Achievement("First Workout", "Complete your first workout", 100),
        Achievement("Weekly Streak", "Workout 3 times in a week", 50),
        Achievement("Monthly Streak", "Workout 15 times in a month", 100),
        Achievement("100 Push-ups", "Complete 100 push-ups", 75)
    )*/
    val achievements by viewModelAchivements.usersState.collectAsStateWithLifecycle()


    val completedAchievements = achievements.filter { it.progress == 100 }
    val inProgressAchievements = achievements.filter { it.progress < 100 }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Completed Achievements", style = MaterialTheme.typography.titleLarge)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green.copy(alpha = 0.1f))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(completedAchievements) { achievement ->
                AchievementItem(achievement)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "In Progress Achievements", style = MaterialTheme.typography.titleLarge)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(inProgressAchievements) { achievement ->
                AchievementItem(achievement)
            }

        }
    }
}

@Composable
fun AchievementItem(achievement: AchiveElement) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = achievement.opis, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = achievement.nazwa, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            if (achievement.progress == 100) {
                Text(
                    text = "Completed",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "In Progress",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    LinearProgressIndicator(
                        progress = achievement.progress / 100f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    Text(
                        text = "${achievement.progress}%",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}