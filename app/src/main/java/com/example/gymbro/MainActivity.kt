package com.example.gymbro

import android.app.Application
import android.os.Bundle
import android.text.style.ClickableSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymbro.ui.theme.GymBroTheme
import com.example.gymbro.ui.theme.model.AchiveElement
import com.example.gymbro.ui.theme.model.InitiateMusclesIfNotExist
import com.example.gymbro.ui.theme.model.Navigation
import com.example.gymbro.ui.theme.view.MainScreenFront
import com.example.gymbro.ui.theme.viewModel.AchiveViewModel
import com.example.gymbro.ui.theme.viewModel.AchiveViewModelFactory
import com.example.gymbro.ui.theme.viewModel.FrontHitboxes
//space for global data
var name_of_exercise: String = ""
var description_of_exercise: String = ""
var length_of_exercise: String = "0.0"
var list_of_selected_muscles: MutableList<String> = mutableListOf()
var klikniety: String = ""
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymBroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}
