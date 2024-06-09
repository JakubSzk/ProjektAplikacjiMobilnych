package com.example.gymbro.ui.theme.view

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymbro.ui.theme.viewModel.MuscleViewModel
import com.example.gymbro.ui.theme.viewModel.MuscleViewModelFactory

@Composable
fun StatsScreen(modifier: Modifier = Modifier.fillMaxSize()){
    val viewModel2: MuscleViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModel2",
        MuscleViewModelFactory(LocalContext.current.applicationContext as Application)
    )
    val historyElements by viewModel2.usersState.collectAsStateWithLifecycle()


    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)

        ) {
            items(historyElements.size) {
//                Text(
//                    text = "${products[it].product} ${products[it].amount}",
//                    fontSize = 32.sp,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(2.dp)
//                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                ) {
                    Column (
                        horizontalAlignment = Alignment.Start,
                        // modifier = Modifier.background(LightGreen)
                    ) {
                        Text(text = historyElements[it].id_m.toString(),
                            fontSize = 32.sp,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column (
                        horizontalAlignment = Alignment.End

                    ) {
                        Text(text = historyElements[it].nazwa_miesnia,
                            fontSize = 32.sp,
                        )
                    }
                }
            }
        }
    }
}