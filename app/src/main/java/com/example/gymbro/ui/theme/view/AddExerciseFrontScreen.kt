package com.example.gymbro.ui.theme.view

import android.app.Application
import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gymbro.description_of_exercise
import com.example.gymbro.length_of_exercise
import com.example.gymbro.list_of_selected_muscles
import com.example.gymbro.name_of_exercise
import com.example.gymbro.ui.theme.LightGreen
import com.example.gymbro.ui.theme.model.ExerciseElement
import com.example.gymbro.ui.theme.model.Screens
import com.example.gymbro.ui.theme.viewModel.ExerciseViewModel
import com.example.gymbro.ui.theme.viewModel.ExerciseViewModelFactory
import com.example.gymbro.ui.theme.viewModel.FrontHitboxes
import com.example.gymbro.ui.theme.viewModel.MuscleViewModel
import com.example.gymbro.ui.theme.viewModel.MuscleViewModelFactory

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddExercisesFrontScreen(navController: NavHostController, bottomPadding: Dp){

    var name_of_exercisee by remember { mutableStateOf("") }
    name_of_exercisee = name_of_exercise
    var description_of_exercisee by remember { mutableStateOf("") }
    description_of_exercisee = description_of_exercise
    var length_of_exercisee by remember { mutableStateOf("0.0") }
    length_of_exercisee = length_of_exercise

    val viewModelExercise: ExerciseViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModelExercise",
        ExerciseViewModelFactory(LocalContext.current.applicationContext as Application)
    )
    val viewModelMuscle: MuscleViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModelMuscle",
        MuscleViewModelFactory(LocalContext.current.applicationContext as Application)
    )
    val listOfMuscles by viewModelMuscle.usersState.collectAsStateWithLifecycle()

    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold ( modifier = Modifier.padding(bottom = bottomPadding),
        floatingActionButton = {
            FloatingActionButton( modifier = Modifier.clickable{},
                onClick = {
                    navController.navigate(Screens.AddExerciseBack.route)
                },
                containerColor = LightGreen
            ) {
                Icon(Icons.Filled.Refresh, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            ) {
                TextField(
                    value = name_of_exercisee,
                    onValueChange = { name_of_exercisee = it },
                    label = { Text("Nazwa") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            name_of_exercise = name_of_exercisee
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                )
                TextField(
                    value = description_of_exercisee,
                    onValueChange = { description_of_exercisee = it },
                    label = { Text("Opis") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            description_of_exercise = description_of_exercisee
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                )
                TextField(
                    value = length_of_exercisee,
                    onValueChange = { length_of_exercisee = it },
                    label = { Text("Długość ruchu") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            length_of_exercise = length_of_exercisee
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                )
                Row (modifier = Modifier.zIndex(1f)) {
                    Spacer(modifier = Modifier.weight(0.075f))
                    Button(onClick = {
                        val listOfElementsToPush = mutableListOf<ExerciseElement>()
                        for (selected in list_of_selected_muscles) {
                            val muscle = listOfMuscles.find { it.nazwa_miesnia == selected }
                            if (muscle != null) {
                                listOfElementsToPush.add(ExerciseElement(0, description_of_exercise, muscle.id_m, length_of_exercise.toFloat(), name_of_exercise))
                            }
                        }

                        for (selected in listOfElementsToPush) {
                            viewModelExercise.addExerciseElement(selected)
                        }
                        name_of_exercise = ""
                        description_of_exercise = ""
                        length_of_exercise = "0.0"
                        list_of_selected_muscles.clear()
                        navController.navigate(Screens.LibraryScreen.route)
                    },
                        modifier = Modifier.weight(0.375f)) {
                        Text(text = "ACCEPT")
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    Button(onClick = {
                        name_of_exercise = ""
                        description_of_exercise = ""
                        length_of_exercise = "0.0"
                        list_of_selected_muscles.clear()
                        navController.navigate(Screens.LibraryScreen.route)
                    },
                        modifier = Modifier.weight(0.375f)) {
                        Text(text = "BACK")
                    }
                    Spacer(modifier = Modifier.weight(0.075f))
                }
                val zmienna = 5f
                val miesnie = FrontHitboxes(zmienna)
                var selectedMuscle by remember { mutableStateOf("") }
                var items by remember { mutableStateOf(listOf<String>()) }
                items = list_of_selected_muscles.toList()
                Canvas(modifier = Modifier.offset(y = (-60).dp).size((zmienna*210).dp, (zmienna*297).dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {tapOffset ->
                                var index = 0
                                //var porown: Pair<Float, Float> = Pair<Float, Float>(tapOffset.x, tapOffset.y)

                                val prawa: Boolean = tapOffset.x > 2
                                for (miesien in miesnie.miesnie)
                                {
                                    var counter: Int = zmienna.toInt()*(81 + 130)/2
                                    for (trojkot in miesien.value)
                                    {
                                        if(counter % 2 == 1 && prawa || counter % 2 == 0 && !prawa) {
                                            val d1 =
                                                tapOffset.x * (trojkot.first.second - trojkot.second.second) + tapOffset.y * (trojkot.second.first - trojkot.first.first) + (trojkot.first.first * trojkot.second.second - trojkot.first.second * trojkot.second.first)
                                            val d2 =
                                                tapOffset.x * (trojkot.second.second - trojkot.third.second) + tapOffset.y * (trojkot.third.first - trojkot.second.first) + (trojkot.second.first * trojkot.third.second - trojkot.second.second * trojkot.third.first)
                                            val d3 =
                                                tapOffset.x * (trojkot.third.second - trojkot.first.second) + tapOffset.y * (trojkot.first.first - trojkot.third.first) + (trojkot.third.first * trojkot.first.second - trojkot.third.second * trojkot.first.first)
                                            if ((d1 <= 0) && (d2 <= 0) && (d3 <= 0) || (d1 >= 0) && (d2 >= 0) && (d3 >= 0)) {
                                                println(miesien.key)
                                                selectedMuscle = miesien.key
                                                if(miesien.key in items) {
                                                    list_of_selected_muscles.remove(miesien.key)
                                                    items = list_of_selected_muscles.toList()
                                                }
                                                else {
                                                    list_of_selected_muscles.add(miesien.key)
                                                    items = list_of_selected_muscles.toList()
                                                }
                                            }
                                        }
                                    }
                                }
                            })})
                {
                    val path = Path()


                    path.relativeMoveTo(zmienna*108.25747F, zmienna*92.855831F)
                    path.relativeCubicTo(zmienna*-0.50534F, zmienna*0.0013F, zmienna*-0.87129F, zmienna*0.05015F, zmienna*-1.01492F, zmienna*0.159163F)
                    path.relativeCubicTo(zmienna*-0.70075F, zmienna*0.531888F, zmienna*-1.69616F, zmienna*6.334486F, zmienna*-0.95911F, zmienna*6.906555F)
                    path.relativeCubicTo(zmienna*0.93339F, zmienna*0.724481F, zmienna*8.82694F, zmienna*5.860081F, zmienna*10.26397F, zmienna*5.819281F)
                    path.relativeCubicTo(zmienna*0.64976F, zmienna*-0.0185F, zmienna*1.73653F, zmienna*-9.077607F, zmienna*-0.54364F, zmienna*-11.287164F)
                    path.relativeCubicTo(zmienna*-0.74274F, zmienna*-0.719734F, zmienna*-5.55636F, zmienna*-1.603548F, zmienna*-7.7463F, zmienna*-1.597835F)
                    path.close()
                    path.relativeMoveTo(zmienna*-4.71444F, zmienna*0.06408F)
                    path.relativeCubicTo(zmienna*-2.18991F, zmienna*-0.0057F, zmienna*-7.003559F, zmienna*0.878101F, zmienna*-7.746293F, zmienna*1.597835F)
                    path.relativeCubicTo(zmienna*-2.280165F, zmienna*2.209557F, zmienna*-1.19339F, zmienna*11.268694F, zmienna*-0.543636F, zmienna*11.287164F)
                    path.relativeCubicTo(zmienna*1.437025F, zmienna*0.0408F, zmienna*9.330549F, zmienna*-5.09532F, zmienna*10.263969F, zmienna*-5.819798F)
                    path.relativeCubicTo(zmienna*0.73705F, zmienna*-0.572069F, zmienna*-0.25836F, zmienna*-6.374667F, zmienna*-0.95911F, zmienna*-6.906555F)
                    path.relativeCubicTo(zmienna*-0.14363F, zmienna*-0.109016F, zmienna*-0.50956F, zmienna*-0.157328F, zmienna*-1.01493F, zmienna*-0.158646F)
                    path.close()
                    path.relativeMoveTo(zmienna*1.42679F, zmienna*9.153449F)
                    path.relativeCubicTo(zmienna*-1.79772F, zmienna*0.12357F, zmienna*-8.040283F, zmienna*4.25312F, zmienna*-9.50898F, zmienna*5.77794F)
                    path.relativeCubicTo(zmienna*-0.748448F, zmienna*0.77705F, zmienna*-0.998691F, zmienna*5.20586F, zmienna*-0.19172F, zmienna*5.11596F)
                    path.relativeCubicTo(zmienna*1.768658F, zmienna*-0.1969F, zmienna*8.73347F, zmienna*-0.74881F, zmienna*10.29601F, zmienna*-2.19056F)
                    path.relativeCubicTo(zmienna*0.40917F, zmienna*-0.37754F, zmienna*0.18371F, zmienna*-7.59585F, zmienna*-0.12815F, zmienna*-8.50542F)
                    path.relativeCubicTo(zmienna*-0.041F, zmienna*-0.11942F, zmienna*-0.14716F, zmienna*-0.18227F, zmienna*-0.30748F, zmienna*-0.19741F)
                    path.relativeCubicTo(zmienna*-0.0484F, zmienna*-0.005F, zmienna*-0.10169F, zmienna*-0.004F, zmienna*-0.15968F, zmienna*-5.1e-4F)
                    path.close()
                    path.relativeMoveTo(zmienna*1.90428F, zmienna*0.032F)
                    path.relativeCubicTo(zmienna*-0.058F, zmienna*-0.004F, zmienna*-0.11125F, zmienna*-0.004F, zmienna*-0.15968F, zmienna*5.1e-4F)
                    path.relativeCubicTo(zmienna*-0.16033F, zmienna*0.0151F, zmienna*-0.26653F, zmienna*0.078F, zmienna*-0.30748F, zmienna*0.19741F)
                    path.relativeCubicTo(zmienna*-0.3119F, zmienna*0.90957F, zmienna*-0.53733F, zmienna*8.12788F, zmienna*-0.12816F, zmienna*8.50542F)
                    path.relativeCubicTo(zmienna*1.56254F, zmienna*1.44175F, zmienna*8.52736F, zmienna*1.99362F, zmienna*10.29602F, zmienna*2.19056F)
                    path.relativeCubicTo(zmienna*0.80697F, zmienna*0.0899F, zmienna*0.55673F, zmienna*-4.33891F, zmienna*-0.19172F, zmienna*-5.11596F)
                    path.relativeCubicTo(zmienna*-1.46871F, zmienna*-1.52482F, zmienna*-7.71129F, zmienna*-5.65437F, zmienna*-9.50898F, zmienna*-5.77794F)
                    path.close()
                    path.relativeMoveTo(zmienna*-4.86379F, zmienna*10.90114F)
                    path.relativeCubicTo(zmienna*-2.451649F, zmienna*0.0166F, zmienna*-5.460042F, zmienna*0.73061F, zmienna*-6.693131F, zmienna*1.55908F)
                    path.relativeCubicTo(zmienna*-0.849504F, zmienna*0.57075F, zmienna*-0.778446F, zmienna*6.88429F, zmienna*0.159681F, zmienna*7.22643F)
                    path.relativeCubicTo(zmienna*2.265641F, zmienna*0.8263F, zmienna*9.45492F, zmienna*1.06124F, zmienna*9.81645F, zmienna*-0.38344F)
                    path.relativeCubicTo(zmienna*0.51614F, zmienna*-2.06249F, zmienna*0.69077F, zmienna*-7.11917F, zmienna*-0.22375F, zmienna*-7.77007F)
                    path.relativeCubicTo(zmienna*-0.6435F, zmienna*-0.45798F, zmienna*-1.77505F, zmienna*-0.64069F, zmienna*-3.05925F, zmienna*-0.632F)
                    path.close()
                    path.relativeMoveTo(zmienna*7.90029F, zmienna*0.0641F)
                    path.relativeCubicTo(zmienna*-1.28417F, zmienna*-0.009F, zmienna*-2.41575F, zmienna*0.17402F, zmienna*-3.05924F, zmienna*0.632F)
                    path.relativeCubicTo(zmienna*-0.91456F, zmienna*0.6509F, zmienna*-0.7399F, zmienna*5.70706F, zmienna*-0.22376F, zmienna*7.76955F)
                    path.relativeCubicTo(zmienna*0.36153F, zmienna*1.44468F, zmienna*7.55029F, zmienna*1.21026F, zmienna*9.81594F, zmienna*0.38396F)
                    path.relativeCubicTo(zmienna*0.93813F, zmienna*-0.34214F, zmienna*1.00967F, zmienna*-6.65568F, zmienna*0.1602F, zmienna*-7.22643F)
                    path.relativeCubicTo(zmienna*-1.23309F, zmienna*-0.82847F, zmienna*-4.24148F, zmienna*-1.54249F, zmienna*-6.69314F, zmienna*-1.55908F)
                    path.close()
                    path.relativeMoveTo(zmienna*4.52686F, zmienna*9.97665F)
                    path.relativeCubicTo(zmienna*-1.9526F, zmienna*-0.0282F, zmienna*-4.92664F, zmienna*0.21301F, zmienna*-6.93808F, zmienna*0.56741F)
                    path.relativeCubicTo(zmienna*-0.6139F, zmienna*0.10816F, zmienna*-0.0468F, zmienna*2.14652F, zmienna*-1.56683F, zmienna*2.17454F)
                    path.relativeCubicTo(zmienna*-1.52003F, zmienna*0.028F, zmienna*-1.20735F, zmienna*-2.01834F, zmienna*-1.82263F, zmienna*-2.11046F)
                    path.relativeCubicTo(zmienna*-3.01616F, zmienna*-0.4516F, zmienna*-8.817448F, zmienna*-1.04709F, zmienna*-8.856819F, zmienna*0.0956F)
                    path.relativeCubicTo(zmienna*-0.167322F, zmienna*4.8564F, zmienna*3.162116F, zmienna*25.73025F, zmienna*10.968839F, zmienna*25.98807F)
                    path.relativeCubicTo(zmienna*7.80672F, zmienna*0.25784F, zmienna*10.19834F, zmienna*-26.33947F, zmienna*10.19834F, zmienna*-26.33947F)
                    path.relativeCubicTo(zmienna*-0.007F, zmienna*-0.24493F, zmienna*-0.81126F, zmienna*-0.35878F, zmienna*-1.98282F, zmienna*-0.37569F)
                    path.close()

                    val path1 = Path()

                    path1.relativeMoveTo(zmienna*99.585136F, zmienna*69.070203F)
                    path1.relativeCubicTo(zmienna*-5.890465F, zmienna*0.02347F, zmienna*-16.140966F, zmienna*2.419274F, zmienna*-16.324585F, zmienna*4.935099F)
                    path1.relativeCubicTo(zmienna*-0.31824F, zmienna*4.360297F, zmienna*19.117609F, zmienna*15.123776F, zmienna*20.710359F, zmienna*14.650785F)
                    path1.relativeCubicTo(zmienna*2.10382F, zmienna*-0.624756F, zmienna*0.35576F, zmienna*-19.03766F, zmienna*-2.17041F, zmienna*-19.444291F)
                    path1.relativeCubicTo(zmienna*-0.62148F, zmienna*-0.100038F, zmienna*-1.37387F, zmienna*-0.144946F, zmienna*-2.215364F, zmienna*-0.141593F)
                    path1.close()
                    path1.relativeMoveTo(zmienna*12.784234F, zmienna*0.06408F)
                    path1.relativeCubicTo(zmienna*-0.8415F, zmienna*-0.0034F, zmienna*-1.59389F, zmienna*0.04156F, zmienna*-2.21537F, zmienna*0.141594F)
                    path1.relativeCubicTo(zmienna*-2.52617F, zmienna*0.40663F, zmienna*-4.27423F, zmienna*18.819535F, zmienna*-2.17041F, zmienna*19.444291F)
                    path1.relativeCubicTo(zmienna*1.59276F, zmienna*0.472991F, zmienna*21.0286F, zmienna*-10.290489F, zmienna*20.71036F, zmienna*-14.650785F)
                    path1.relativeCubicTo(zmienna*-0.18362F, zmienna*-2.515825F, zmienna*-10.43412F, zmienna*-4.91163F, zmienna*-16.32458F, zmienna*-4.9351F)
                    path1.close()

                    val path2 = Path()

                    path2.relativeMoveTo(zmienna*83.232646F, zmienna*75.895109F)
                    path2.relativeCubicTo(zmienna*-0.914268F, zmienna*0.07149F, zmienna*1.062395F, zmienna*9.046752F, zmienna*3.163631F, zmienna*11.619963F)
                    path2.relativeCubicTo(zmienna*3.877819F, zmienna*4.748849F, zmienna*9.730727F, zmienna*6.682659F, zmienna*17.586523F, zmienna*4.796089F)
                    path2.relativeCubicTo(zmienna*0.62182F, zmienna*-0.14933F, zmienna*1.02188F, zmienna*-3.201911F, zmienna*0.38344F, zmienna*-3.165181F)
                    path2.relativeCubicTo(zmienna*-5.647121F, zmienna*0.324929F, zmienna*-20.359026F, zmienna*-12.643513F, zmienna*-20.911386F, zmienna*-13.141834F)
                    path2.relativeCubicTo(zmienna*-0.08747F, zmienna*-0.07891F, zmienna*-0.161257F, zmienna*-0.113803F, zmienna*-0.222208F, zmienna*-0.109037F)
                    path2.close()
                    path2.relativeMoveTo(zmienna*45.496444F, zmienna*0.06408F)
                    path2.relativeCubicTo(zmienna*-0.061F, zmienna*-0.0048F, zmienna*-0.13473F, zmienna*0.03012F, zmienna*-0.22221F, zmienna*0.109037F)
                    path2.relativeCubicTo(zmienna*-0.55235F, zmienna*0.498321F, zmienna*-15.26426F, zmienna*13.466247F, zmienna*-20.91138F, zmienna*13.141317F)
                    path2.relativeCubicTo(zmienna*-0.63844F, zmienna*-0.03673F, zmienna*-0.23838F, zmienna*3.016368F, zmienna*0.38344F, zmienna*3.165698F)
                    path2.relativeCubicTo(zmienna*7.8558F, zmienna*1.88657F, zmienna*13.70819F, zmienna*-0.04724F, zmienna*17.58601F, zmienna*-4.79609F)
                    path2.relativeCubicTo(zmienna*2.10123F, zmienna*-2.57321F, zmienna*4.07841F, zmienna*-11.54847F, zmienna*3.16414F, zmienna*-11.619962F)
                    path2.close()

                    val path3 = Path()

                    path3.relativeMoveTo(zmienna*83.534953F, zmienna*64.849272F)
                    path3.relativeCubicTo(zmienna*-4.779812F, zmienna*-0.186271F, zmienna*-10.466136F, zmienna*6.701531F, zmienna*-10.980725F, zmienna*10.395748F)
                    path3.relativeCubicTo(zmienna*-0.42058F, zmienna*3.019315F, zmienna*2.411379F, zmienna*9.990453F, zmienna*3.481958F, zmienna*10.038663F)
                    path3.relativeCubicTo(zmienna*4.396035F, zmienna*0.197962F, zmienna*5.34789F, zmienna*-11.307803F, zmienna*7.099308F, zmienna*-13.113928F)
                    path3.relativeCubicTo(zmienna*2.581497F, zmienna*-2.662136F, zmienna*10.237576F, zmienna*-1.833402F, zmienna*10.717175F, zmienna*-2.984314F)
                    path3.relativeCubicTo(zmienna*0.4935F, zmienna*-1.184263F, zmienna*-7.721108F, zmienna*-3.999789F, zmienna*-9.857796F, zmienna*-4.295862F)
                    path3.relativeCubicTo(zmienna*-0.152096F, zmienna*-0.02107F, zmienna*-0.305733F, zmienna*-0.0343F, zmienna*-0.45992F, zmienna*-0.04031F)
                    path3.close()
                    path3.relativeMoveTo(zmienna*45.075797F, zmienna*0F)
                    path3.relativeCubicTo(zmienna*-0.15418F, zmienna*0.006F, zmienna*-0.3073F, zmienna*0.01923F, zmienna*-0.4594F, zmienna*0.04031F)
                    path3.relativeCubicTo(zmienna*-2.13669F, zmienna*0.296073F, zmienna*-10.35129F, zmienna*3.111599F, zmienna*-9.8578F, zmienna*4.295862F)
                    path3.relativeCubicTo(zmienna*0.4796F, zmienna*1.150912F, zmienna*8.13568F, zmienna*0.322178F, zmienna*10.71718F, zmienna*2.984314F)
                    path3.relativeCubicTo(zmienna*1.75142F, zmienna*1.806125F, zmienna*2.70327F, zmienna*13.31189F, zmienna*7.09931F, zmienna*13.113928F)
                    path3.relativeCubicTo(zmienna*1.07058F, zmienna*-0.04821F, zmienna*3.90254F, zmienna*-7.019348F, zmienna*3.48196F, zmienna*-10.038663F)
                    path3.relativeCubicTo(zmienna*-0.51459F, zmienna*-3.694217F, zmienna*-6.20143F, zmienna*-10.582019F, zmienna*-10.98125F, zmienna*-10.395748F)
                    path3.close()

                    val path4 = Path()

                    path4.relativeMoveTo(zmienna*98.628605F, zmienna*55.122217F)
                    path4.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-0.06388F, zmienna*5.931529F, zmienna*-10.400399F, zmienna*10.129097F)
                    path4.relativeCubicTo(zmienna*-1.727388F, zmienna*0.701479F, zmienna*12.755704F, zmienna*5.915131F, zmienna*14.741224F, zmienna*2.260844F)
                    path4.relativeCubicTo(zmienna*1.22502F, zmienna*-2.254638F, zmienna*-4.340825F, zmienna*-12.389941F, zmienna*-4.340825F, zmienna*-12.389941F)
                    path4.close()
                    path4.relativeMoveTo(zmienna*14.600145F, zmienna*0.04548F)
                    path4.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-5.56585F, zmienna*10.135304F, zmienna*-4.34082F, zmienna*12.389941F)
                    path4.relativeCubicTo(zmienna*1.98552F, zmienna*3.654287F, zmienna*16.46912F, zmienna*-1.559365F, zmienna*14.74173F, zmienna*-2.260843F)
                    path4.relativeCubicTo(zmienna*-10.33652F, zmienna*-4.197568F, zmienna*-10.40091F, zmienna*-10.129098F, zmienna*-10.40091F, zmienna*-10.129098F)
                    path4.close()

                    val path5 = Path()

                    path5.relativeMoveTo(zmienna*124.93914F, zmienna*89.520634F)
                    path5.relativeCubicTo(zmienna*-1.73031F, zmienna*0.109051F, zmienna*-4.02142F, zmienna*2.469621F, zmienna*-5.35316F, zmienna*4.357357F)
                    path5.relativeCubicTo(zmienna*-1.97021F, zmienna*2.792767F, zmienna*-1.09016F, zmienna*12.981019F, zmienna*-0.89555F, zmienna*15.731859F)
                    path5.relativeCubicTo(zmienna*0.0799F, zmienna*1.1291F, zmienna*-2.20989F, zmienna*28.07157F, zmienna*2.87786F, zmienna*25.57983F)
                    path5.relativeCubicTo(zmienna*6.42944F, zmienna*-3.14883F, zmienna*3.11835F, zmienna*-21.49888F, zmienna*3.32538F, zmienna*-25.00416F)
                    path5.relativeCubicTo(zmienna*0.13919F, zmienna*-2.35658F, zmienna*3.13366F, zmienna*-13.813625F, zmienna*3.13366F, zmienna*-13.813625F)
                    path5.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-0.31002F, zmienna*-6.54166F, zmienna*-2.74971F, zmienna*-6.842476F)
                    path5.relativeCubicTo(zmienna*-0.10991F, zmienna*-0.01355F, zmienna*-0.22312F, zmienna*-0.01606F, zmienna*-0.33848F, zmienna*-0.0088F)
                    path5.close()
                    path5.relativeMoveTo(zmienna*-38.1186F, zmienna*0.664042F)
                    path5.relativeCubicTo(zmienna*-0.115354F, zmienna*-0.0073F, zmienna*-0.228564F, zmienna*-0.0048F, zmienna*-0.33848F, zmienna*0.0088F)
                    path5.relativeCubicTo(zmienna*-2.439688F, zmienna*0.300816F, zmienna*-2.749703F, zmienna*6.842993F, zmienna*-2.749703F, zmienna*6.842993F)
                    path5.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*2.994469F, zmienna*11.456531F, zmienna*3.133659F, zmienna*13.813101F)
                    path5.relativeCubicTo(zmienna*0.207029F, zmienna*3.50528F, zmienna*-3.104066F, zmienna*21.85534F, zmienna*3.325378F, zmienna*25.00416F)
                    path5.relativeCubicTo(zmienna*5.087755F, zmienna*2.49174F, zmienna*2.797444F, zmienna*-24.45073F, zmienna*2.877344F, zmienna*-25.57983F)
                    path5.relativeCubicTo(zmienna*0.19461F, zmienna*-2.75084F, zmienna*1.075172F, zmienna*-12.939085F, zmienna*-0.895036F, zmienna*-15.731852F)
                    path5.relativeCubicTo(zmienna*-1.331736F, zmienna*-1.887736F, zmienna*-3.622849F, zmienna*-4.248305F, zmienna*-5.353162F, zmienna*-4.357357F)
                    path5.close()

                    val path6 = Path()

                    path6.relativeMoveTo(zmienna*80.666911F, zmienna*64.71698F)
                    path6.relativeCubicTo(zmienna*-7.938882F, zmienna*-0.02337F, zmienna*-10.278182F, zmienna*5.067856F, zmienna*-10.519772F, zmienna*10.284127F)
                    path6.relativeCubicTo(zmienna*-0.224719F, zmienna*4.852309F, zmienna*1.098695F, zmienna*13.935346F, zmienna*2.014865F, zmienna*14.432711F)
                    path6.relativeCubicTo(zmienna*0.405659F, zmienna*0.220219F, zmienna*3.547317F, zmienna*-1.94751F, zmienna*3.708817F, zmienna*-3.549655F)
                    path6.relativeCubicTo(zmienna*0.07477F, zmienna*-0.741785F, zmienna*-2.695838F, zmienna*-5.524216F, zmienna*-3.389457F, zmienna*-8.377266F)
                    path6.relativeCubicTo(zmienna*-0.623049F, zmienna*-2.562749F, zmienna*0.08738F, zmienna*-4.521682F, zmienna*1.21543F, zmienna*-6.362919F)
                    path6.relativeCubicTo(zmienna*2.142947F, zmienna*-3.497776F, zmienna*7.454956F, zmienna*-6.425598F, zmienna*6.970117F, zmienna*-6.426998F)
                    path6.close()
                    path6.relativeMoveTo(zmienna*50.749869F, zmienna*0.128158F)
                    path6.relativeCubicTo(zmienna*-0.48483F, zmienna*0.0014F, zmienna*4.82717F, zmienna*2.929222F, zmienna*6.97012F, zmienna*6.426997F)
                    path6.relativeCubicTo(zmienna*1.12805F, zmienna*1.841238F, zmienna*1.83848F, zmienna*3.80017F, zmienna*1.21543F, zmienna*6.36292F)
                    path6.relativeCubicTo(zmienna*-0.69362F, zmienna*2.85305F, zmienna*-3.46423F, zmienna*7.635481F, zmienna*-3.38946F, zmienna*8.377266F)
                    path6.relativeCubicTo(zmienna*0.1615F, zmienna*1.602144F, zmienna*3.30316F, zmienna*3.769357F, zmienna*3.70882F, zmienna*3.549137F)
                    path6.relativeCubicTo(zmienna*0.91617F, zmienna*-0.497364F, zmienna*2.23959F, zmienna*-9.580401F, zmienna*2.01487F, zmienna*-14.43271F)
                    path6.relativeCubicTo(zmienna*-0.24159F, zmienna*-5.216271F, zmienna*-2.58089F, zmienna*-10.306976F, zmienna*-10.51978F, zmienna*-10.28361F)
                    path6.close()

                    val path7 = Path()

                    path7.relativeMoveTo(zmienna*129.97966F, zmienna*80.120174F)
                    path7.relativeCubicTo(zmienna*-0.0897F, zmienna*0.0095F, zmienna*-0.17149F, zmienna*0.04189F, zmienna*-0.24546F, zmienna*0.0987F)
                    path7.relativeCubicTo(zmienna*-5.82334F, zmienna*4.47266F, zmienna*1.98802F, zmienna*30.640436F, zmienna*9.45059F, zmienna*24.870836F)
                    path7.relativeCubicTo(zmienna*3.59435F, zmienna*-3.45126F, zmienna*-6.42358F, zmienna*-25.262526F, zmienna*-9.20513F, zmienna*-24.969538F)
                    path7.close()
                    path7.relativeMoveTo(zmienna*-48.002235F, zmienna*0.128158F)
                    path7.relativeCubicTo(zmienna*-2.781544F, zmienna*-0.292988F, zmienna*-12.799472F, zmienna*21.517758F, zmienna*-9.205123F, zmienna*24.969018F)
                    path7.relativeCubicTo(zmienna*7.462563F, zmienna*5.7696F, zmienna*15.274447F, zmienna*-20.397657F, zmienna*9.451103F, zmienna*-24.870316F)
                    path7.relativeCubicTo(zmienna*-0.07397F, zmienna*-0.05681F, zmienna*-0.156253F, zmienna*-0.08925F, zmienna*-0.24598F, zmienna*-0.0987F)
                    path7.close()

                    val path8 = Path()

                    path8.relativeMoveTo(zmienna*135.33541F, zmienna*85.931706F)
                    path8.relativeCubicTo(zmienna*-0.0614F, zmienna*-0.007F, zmienna*-0.0907F, zmienna*0.02805F, zmienna*-0.0816F, zmienna*0.112654F)
                    path8.relativeCubicTo(zmienna*0.35947F, zmienna*3.370123F, zmienna*3.79216F, zmienna*5.333202F, zmienna*5.40329F, zmienna*18.19372F)
                    path8.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*1.92715F, zmienna*2.44424F, zmienna*2.11046F, zmienna*1.34307F)
                    path8.relativeCubicTo(zmienna*0.79876F, zmienna*-4.79826F, zmienna*-1.22943F, zmienna*-13.904993F, zmienna*-2.30218F, zmienna*-14.804779F)
                    path8.relativeCubicTo(zmienna*-0.94608F, zmienna*-0.793542F, zmienna*-4.5366F, zmienna*-4.77653F, zmienna*-5.12992F, zmienna*-4.844665F)
                    path8.close()
                    path8.relativeMoveTo(zmienna*-58.669805F, zmienna*0.271301F)
                    path8.relativeCubicTo(zmienna*-0.593322F, zmienna*0.06813F, zmienna*-4.183841F, zmienna*4.051123F, zmienna*-5.12992F, zmienna*4.844666F)
                    path8.relativeCubicTo(zmienna*-1.072749F, zmienna*0.899786F, zmienna*-3.100944F, zmienna*10.006517F, zmienna*-2.302185F, zmienna*14.804777F)
                    path8.relativeCubicTo(zmienna*0.18331F, zmienna*1.10117F, zmienna*2.109949F, zmienna*-1.34307F, zmienna*2.109949F, zmienna*-1.34307F)
                    path8.relativeCubicTo(zmienna*1.611128F, zmienna*-12.860521F, zmienna*5.044335F, zmienna*-14.823596F, zmienna*5.403804F, zmienna*-18.193718F)
                    path8.relativeCubicTo(zmienna*0.009F, zmienna*-0.08461F, zmienna*-0.02027F, zmienna*-0.119703F, zmienna*-0.08165F, zmienna*-0.112655F)
                    path8.close()

                    val path9 = Path()

                    path9.relativeMoveTo(zmienna*154.59056F, zmienna*141.90968F)
                    path9.relativeCubicTo(zmienna*-1.94884F, zmienna*0.0272F, zmienna*-4.38278F, zmienna*1.9272F, zmienna*-5.90765F, zmienna*2.93626F)
                    path9.relativeCubicTo(zmienna*-3.38323F, zmienna*2.23883F, zmienna*3.6836F, zmienna*18.78017F, zmienna*8.50543F, zmienna*13.36559F)
                    path9.relativeCubicTo(zmienna*7.08773F, zmienna*-7.95901F, zmienna*1.70396F, zmienna*-14.17075F, zmienna*-1.34307F, zmienna*-15.98765F)
                    path9.relativeCubicTo(zmienna*-0.38091F, zmienna*-0.22713F, zmienna*-0.80497F, zmienna*-0.32048F, zmienna*-1.25471F, zmienna*-0.3142F)
                    path9.close()
                    path9.relativeMoveTo(zmienna*-97.335657F, zmienna*0.23255F)
                    path9.relativeCubicTo(zmienna*-0.449733F, zmienna*-0.006F, zmienna*-0.873792F, zmienna*0.0871F, zmienna*-1.254704F, zmienna*0.31419F)
                    path9.relativeCubicTo(zmienna*-3.047037F, zmienna*1.8169F, zmienna*-8.430286F, zmienna*8.02813F, zmienna*-1.342553F, zmienna*15.98714F)
                    path9.relativeCubicTo(zmienna*4.821825F, zmienna*5.41457F, zmienna*11.888144F, zmienna*-11.12625F, zmienna*8.504907F, zmienna*-13.36508F)
                    path9.relativeCubicTo(zmienna*-1.524866F, zmienna*-1.00906F, zmienna*-3.958804F, zmienna*-2.90901F, zmienna*-5.90765F, zmienna*-2.93625F)
                    path9.close()

                    val path10 = Path()

                    path10.relativeMoveTo(zmienna*115.74803F, zmienna*40.290347F)
                    path10.relativeCubicTo(zmienna*0.38913F, zmienna*2.346069F, zmienna*-0.56944F, zmienna*13.000492F, zmienna*-1.90469F, zmienna*13.929799F)
                    path10.relativeCubicTo(zmienna*-5.22209F, zmienna*3.634462F, zmienna*-11.15181F, zmienna*3.654476F, zmienna*-16.262483F, zmienna*-0.435734F)
                    path10.relativeCubicTo(zmienna*-1.03254F, zmienna*-0.826371F, zmienna*-1.535086F, zmienna*-11.049943F, zmienna*-1.367548F, zmienna*-13.313188F)
                    path10.relativeCubicTo(zmienna*0.550372F, zmienna*-7.434892F, zmienna*18.241921F, zmienna*-7.975101F, zmienna*19.534721F, zmienna*-0.180877F)
                    path10.close()

                    val path11 = Path()

                    path11.relativeMoveTo(zmienna*125.65641F, zmienna*132.66684F)
                    path11.relativeMoveTo(zmienna*-11.39517F, zmienna*13.11341F)
                    path11.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-2.25099F, zmienna*8.06846F, zmienna*-7.41608F, zmienna*10.49083F)
                    path11.relativeCubicTo(zmienna*-1.15895F, zmienna*0.54353F, zmienna*3.65761F, zmienna*29.16814F, zmienna*4.70307F, zmienna*29.48296F)
                    path11.relativeCubicTo(zmienna*8.81433F, zmienna*-15.30925F, zmienna*10.98554F, zmienna*-35.72223F, zmienna*14.10818F, zmienna*-53.0872F)
                    path11.close()
                    path11.moveTo(zmienna*125.65641F, zmienna*132.66684F)
                    path11.relativeMoveTo(zmienna*-39.111822F, zmienna*0.22944F)
                    path11.relativeCubicTo(zmienna*3.122652F, zmienna*17.36497F, zmienna*5.293848F, zmienna*37.77796F, zmienna*14.108182F, zmienna*53.0872F)
                    path11.relativeCubicTo(zmienna*1.04546F, zmienna*-0.31482F, zmienna*5.86151F, zmienna*-29.2593F, zmienna*4.70256F, zmienna*-29.80283F)
                    path11.relativeCubicTo(zmienna*-5.16509F, zmienna*-2.42237F, zmienna*-7.415572F, zmienna*-10.17096F, zmienna*-7.415572F, zmienna*-10.17096F)
                    path11.close()

                    val path12 = Path()

                    path12.relativeMoveTo(zmienna*117.29878F, zmienna*174.63689F)
                    path12.relativeMoveTo(zmienna*-5.15524F, zmienna*10.943F)
                    path12.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-2.16166F, zmienna*13.30852F, zmienna*4.97438F, zmienna*12.48037F)
                    path12.relativeCubicTo(zmienna*4.46754F, zmienna*-0.51847F, zmienna*0.33878F, zmienna*-19.77467F, zmienna*0.18086F, zmienna*-23.42337F)
                    path12.close()
                    path12.moveTo(zmienna*117.29878F, zmienna*174.63689F)
                    path12.relativeMoveTo(zmienna*-22.474594F, zmienna*0.045F)
                    path12.relativeCubicTo(zmienna*-0.15792F, zmienna*3.64871F, zmienna*-4.286681F, zmienna*22.90543F, zmienna*0.180868F, zmienna*23.4239F)
                    path12.relativeCubicTo(zmienna*7.136036F, zmienna*0.82815F, zmienna*4.973856F, zmienna*-12.48089F, zmienna*4.973856F, zmienna*-12.48089F)
                    path12.close()

                    val path13 = Path()

                    path13.relativeMoveTo(zmienna*88.350163F, zmienna*146.28668F)
                    path13.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-0.786517F, zmienna*13.65274F, zmienna*-0.180868F, zmienna*20.43906F)
                    path13.relativeCubicTo(zmienna*0.64909F, zmienna*7.27299F, zmienna*4.069519F, zmienna*21.52427F, zmienna*4.069519F, zmienna*21.52427F)
                    path13.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*2.99137F, zmienna*-12.7986F, zmienna*2.261361F, zmienna*-15.19339F)
                    path13.relativeCubicTo(zmienna*-2.996467F, zmienna*-9.82983F, zmienna*-4.365604F, zmienna*-17.61766F, zmienna*-6.150012F, zmienna*-26.76994F)
                    path13.close()
                    path13.relativeMoveTo(zmienna*35.369937F, zmienna*0.22376F)
                    path13.relativeCubicTo(zmienna*-1.78441F, zmienna*9.15228F, zmienna*-3.15355F, zmienna*16.94011F, zmienna*-6.15002F, zmienna*26.76994F)
                    path13.relativeCubicTo(zmienna*-0.73F, zmienna*2.39479F, zmienna*2.26085F, zmienna*15.19339F, zmienna*2.26085F, zmienna*15.19339F)
                    path13.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*3.42095F, zmienna*-14.25128F, zmienna*4.07003F, zmienna*-21.52427F)
                    path13.relativeCubicTo(zmienna*0.60565F, zmienna*-6.78632F, zmienna*-0.18086F, zmienna*-20.43906F, zmienna*-0.18086F, zmienna*-20.43906F)
                    path13.close()

                    val path14 = Path()

                    path14.relativeMoveTo(zmienna*126.43311F, zmienna*132.49217F)
                    path14.relativeCubicTo(zmienna*-4.72597F, zmienna*18.92541F, zmienna*-0.97914F, zmienna*12.60466F, zmienna*-1.53737F, zmienna*30.65911F)
                    path14.relativeCubicTo(zmienna*-0.62707F, zmienna*9.74659F, zmienna*-7.40841F, zmienna*28.99057F, zmienna*-0.63304F, zmienna*32.2864F)
                    path14.relativeCubicTo(zmienna*0.81327F, zmienna*0.39561F, zmienna*2.45958F, zmienna*0.86815F, zmienna*2.71301F, zmienna*0F)
                    path14.relativeCubicTo(zmienna*3.2951F, zmienna*-11.2879F, zmienna*4.57401F, zmienna*-25.4417F, zmienna*4.06952F, zmienna*-38.25554F)
                    path14.relativeCubicTo(zmienna*-0.32936F, zmienna*-8.36579F, zmienna*-4.61212F, zmienna*-24.68997F, zmienna*-4.61212F, zmienna*-24.68997F)
                    path14.close()
                    path14.relativeMoveTo(zmienna*-40.774773F, zmienna*0.45217F)
                    path14.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-4.282762F, zmienna*16.32417F, zmienna*-4.612121F, zmienna*24.68997F)
                    path14.relativeCubicTo(zmienna*-0.50449F, zmienna*12.81384F, zmienna*0.774422F, zmienna*26.96764F, zmienna*4.069519F, zmienna*38.25554F)
                    path14.relativeCubicTo(zmienna*0.25343F, zmienna*0.86815F, zmienna*1.899743F, zmienna*0.39561F, zmienna*2.713013F, zmienna*0F)
                    path14.relativeCubicTo(zmienna*6.775373F, zmienna*-3.29583F, zmienna*-0.006F, zmienna*-22.53981F, zmienna*-0.633037F, zmienna*-32.2864F)
                    path14.relativeCubicTo(zmienna*-0.558229F, zmienna*-18.05445F, zmienna*3.188592F, zmienna*-11.7337F, zmienna*-1.537374F, zmienna*-30.65911F)
                    path14.close()

                    val path15 = Path()

                    path15.relativeMoveTo(zmienna*115.36505F, zmienna*208.73196F)
                    path15.relativeCubicTo(zmienna*0.30327F, zmienna*11.5243F, zmienna*-3.62673F, zmienna*16.47879F, zmienna*-2.42982F, zmienna*20.97547F)
                    path15.relativeCubicTo(zmienna*1.75682F, zmienna*6.60026F, zmienna*4.34857F, zmienna*20.46386F, zmienna*4.34857F, zmienna*20.46386F)
                    path15.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*6.23734F, zmienna*-16.48066F, zmienna*5.37176F, zmienna*-24.94059F)
                    path15.relativeCubicTo(zmienna*-0.61199F, zmienna*-5.9814F, zmienna*-7.29051F, zmienna*-16.49874F, zmienna*-7.29051F, zmienna*-16.49874F)
                    path15.close()
                    path15.relativeMoveTo(zmienna*-18.889802F, zmienna*0.0904F)
                    path15.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-6.678005F, zmienna*10.51734F, zmienna*-7.289994F, zmienna*16.49873F)
                    path15.relativeCubicTo(zmienna*-0.865579F, zmienna*8.45993F, zmienna*5.371765F, zmienna*24.9406F, zmienna*5.371765F, zmienna*24.9406F)
                    path15.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*2.591744F, zmienna*-13.86361F, zmienna*4.348572F, zmienna*-20.46387F)
                    path15.relativeCubicTo(zmienna*1.196909F, zmienna*-4.49668F, zmienna*-2.733612F, zmienna*-9.45117F, zmienna*-2.430343F, zmienna*-20.97546F)
                    path15.close()

                    val path16 = Path()

                    path16.relativeMoveTo(zmienna*85.525012F, zmienna*204.66244F)
                    path16.relativeCubicTo(zmienna*0F, zmienna*0F,zmienna*-1.487908F, zmienna*5.92329F,zmienna*-1.627807F, zmienna*8.95346F)
                    path16.relativeCubicTo(zmienna*-0.28612F, zmienna*6.19714F, zmienna*0.485468F, zmienna*12.4423F, zmienna*1.627807F, zmienna*18.53996F)
                    path16.relativeCubicTo(zmienna*1.352679F, zmienna*7.2204F, zmienna*6.150012F, zmienna*21.16253F, zmienna*6.150012F, zmienna*21.16253F)
                    path16.relativeLineTo(zmienna*-3.255615F,zmienna*-27.71976F)
                    path16.close()
                    path16.moveTo(zmienna*85.525012F, zmienna*204.66244F)
                    path16.relativeMoveTo(zmienna*40.636798F, zmienna*0F)
                    path16.relativeMoveTo(zmienna*-2.8944F, zmienna*20.93619F)
                    path16.relativeMoveTo(zmienna*-3.25561F, zmienna*27.71976F)
                    path16.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*4.79733F,zmienna*-13.94213F, zmienna*6.15001F,zmienna*-21.16253F)
                    path16.relativeCubicTo(zmienna*1.14234F, zmienna*-6.09766F, zmienna*1.91393F,zmienna*-12.34282F, zmienna*1.62781F,zmienna*-18.53996F)
                    path16.relativeCubicTo(zmienna*-0.1399F, zmienna*-3.03017F, zmienna*-1.62781F,zmienna*-8.95346F,zmienna*-1.62781F,zmienna*-8.95346F)
                    path16.close()

                    val path17 = Path()

                    path17.relativeMoveTo(zmienna*83.594897F, zmienna*213.46397F)
                    path17.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-2.000458F, zmienna*9.98757F, zmienna*-1.790588F, zmienna*15.02803F)
                    path17.relativeCubicTo(zmienna*0.35393F, zmienna*8.50007F, zmienna*5.115967F, zmienna*25.00467F, zmienna*5.115967F, zmienna*25.00467F)
                    path17.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*3.155343F, zmienna*-4.13568F, zmienna*2.366264F, zmienna*-6.20324F)
                    path17.relativeCubicTo(zmienna*-4.322646F, zmienna*-11.27764F, zmienna*-4.827893F, zmienna*-22.0248F, zmienna*-5.691643F, zmienna*-33.82946F)
                    path17.close()
                    path17.relativeMoveTo(zmienna*44.560073F, zmienna*0.12816F)
                    path17.relativeCubicTo(zmienna*-0.86375F, zmienna*11.80466F, zmienna*-1.36848F, zmienna*22.5513F, zmienna*-5.69113F, zmienna*33.82894F)
                    path17.relativeCubicTo(zmienna*-0.78908F, zmienna*2.06756F, zmienna*2.36575F, zmienna*6.20324F, zmienna*2.36575F, zmienna*6.20324F)
                    path17.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*4.76204F, zmienna*-16.50408F, zmienna*5.11597F, zmienna*-25.00416F)
                    path17.relativeCubicTo(zmienna*0.20987F, zmienna*-5.04045F, zmienna*-1.79059F, zmienna*-15.02802F, zmienna*-1.79059F, zmienna*-15.02802F)
                    path17.close()

                    val path18 = Path()

                    path18.relativeMoveTo(zmienna*124.80511F, zmienna*253.95127F)
                    path18.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-0.019F, zmienna*2.37185F, zmienna*4.7028F, zmienna*4.88368F)
                    path18.relativeCubicTo(zmienna*4.59856F, zmienna*2.44625F, zmienna*8.29052F, zmienna*3.02952F, zmienna*9.58649F, zmienna*3.93408F)
                    path18.relativeCubicTo(zmienna*1.90842F, zmienna*1.33204F, zmienna*2.77248F, zmienna*3.71508F, zmienna*0.4974F, zmienna*4.20539F)
                    path18.relativeCubicTo(zmienna*-7.80344F, zmienna*1.68175F, zmienna*-9.92209F, zmienna*-2.44461F, zmienna*-23.7401F, zmienna*-3.43666F)
                    path18.relativeCubicTo(zmienna*-3.68602F, zmienna*-0.26463F, zmienna*1.26614F, zmienna*-12.93271F, zmienna*1.26614F, zmienna*-12.93271F)

                    val path19 = Path()

                    path19.relativeMoveTo(zmienna*86.930428F, zmienna*253.6283F)
                    path19.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*0.019F, zmienna*2.37185F, zmienna*-4.7028F, zmienna*4.88368F)
                    path19.relativeCubicTo(zmienna*-4.59856F, zmienna*2.44625F, zmienna*-8.29052F, zmienna*3.02952F, zmienna*-9.58649F, zmienna*3.93408F)
                    path19.relativeCubicTo(zmienna*-1.90842F, zmienna*1.33204F, zmienna*-2.77248F, zmienna*3.71508F, zmienna*-0.4974F, zmienna*4.20539F)
                    path19.relativeCubicTo(zmienna*7.80344F, zmienna*1.68175F, zmienna*9.92209F, zmienna*-2.44461F, zmienna*23.7401F, zmienna*-3.43666F)
                    path19.relativeCubicTo(zmienna*3.68602F, zmienna*-0.26463F, zmienna*-1.26614F, zmienna*-12.93271F, zmienna*-1.26614F, zmienna*-12.93271F)

                    val path20 = Path()

                    path20.relativeMoveTo(zmienna*68.443884F, zmienna*103.6469F)
                    path20.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-5.056467F, zmienna*6.59807F, zmienna*-6.240446F, zmienna*10.49084F)
                    path20.relativeCubicTo(zmienna*-2.373277F, zmienna*7.80305F, zmienna*-3.970751F, zmienna*20.2441F, zmienna*-3.888651F, zmienna*27.22211F)
                    path20.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*9.283988F, zmienna*-22.5004F, zmienna*11.304736F, zmienna*-28.75949F)
                    path20.relativeCubicTo(zmienna*0.924799F, zmienna*-2.86449F, zmienna*-1.175639F, zmienna*-8.95346F, zmienna*-1.175639F, zmienna*-8.95346F)
                    path20.close()
                    path20.relativeMoveTo(zmienna*74.991806F, zmienna*0.17674F)
                    path20.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-2.10096F, zmienna*6.08844F, zmienna*-1.17616F, zmienna*8.95294F)
                    path20.relativeCubicTo(zmienna*2.02075F, zmienna*6.25908F, zmienna*11.30526F, zmienna*28.75948F, zmienna*11.30526F, zmienna*28.75948F)
                    path20.relativeCubicTo(zmienna*0.0821F, zmienna*-6.978F, zmienna*-1.51589F, zmienna*-19.41854F, zmienna*-3.88917F, zmienna*-27.22159F)
                    path20.relativeCubicTo(zmienna*-1.18398F, zmienna*-3.89277F, zmienna*-6.23993F, zmienna*-10.49083F, zmienna*-6.23993F, zmienna*-10.49083F)
                    path20.close()

                    val path21 = Path()

                    path21.relativeMoveTo(zmienna*70.820483F, zmienna*109.97313F)
                    path21.relativeMoveTo(zmienna*-11.440645F, zmienna*30.83946F)
                    path21.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*2.823105F, zmienna*3.54723F, zmienna*3.391524F, zmienna*2.3518F)
                    path21.relativeCubicTo(zmienna*6.915913F, zmienna*-14.54478F, zmienna*14.246013F, zmienna*-19.27973F, zmienna*13.475664F, zmienna*-27.49341F)
                    path21.relativeCubicTo(zmienna*-0.25877F, zmienna*-2.75904F, zmienna*-5.426543F, zmienna*-5.69785F, zmienna*-5.426543F, zmienna*-5.69785F)
                    path21.close()
                    path21.moveTo(zmienna*70.820483F, zmienna*109.97313F)
                    path21.relativeMoveTo(zmienna*70.353847F, zmienna*0.36174F)
                    path21.relativeCubicTo(zmienna*0F, zmienna*0F, zmienna*-5.16726F, zmienna*2.9388F, zmienna*-5.42603F, zmienna*5.69784F)
                    path21.relativeCubicTo(zmienna*-0.77035F, zmienna*8.21368F, zmienna*6.55924F, zmienna*12.94864F, zmienna*13.47515F, zmienna*27.49341F)
                    path21.relativeCubicTo(zmienna*0.56842F, zmienna*1.19543F, zmienna*3.39152F, zmienna*-2.35179F, zmienna*3.39152F, zmienna*-2.35179F)
                    path21.close()

                    drawPath( //brzuch
                        path = path,
                        color =  if ("brzuch" in items) Color.Green else Color.Black
                    )
                    drawPath( //klata gora
                        path = path1,
                        color = if ("klata_gora" in items) Color.Green else Color.Black
                    )
                    drawPath( //klata dol
                        path = path2,
                        color = if ("klata_dol" in items) Color.Green else Color.Black
                    )
                    drawPath( //barki
                        path = path3,
                        color = if ("barki" in items) Color.Green else Color.Black
                    )
                    drawPath( //szyja
                        path = path4,
                        color = if ("szyja" in items) Color.Green else Color.Black
                    )
                    drawPath( //boki
                        path = path5,
                        color = if ("boki" in items) Color.Green else Color.Black
                    )
                    drawPath( //barki_szersze
                        path = path6,
                        color =  if ("barki_szersze" in items) Color.Green else Color.Black
                    )
                    drawPath( //biceps
                        path = path7,
                        color =  if ("biceps" in items) Color.Green else Color.Black
                    )
                    drawPath( //triceps
                        path = path8,
                        color =  if ("triceps" in items) Color.Green else Color.Black
                    )
                    drawPath( //dlon
                        path = path9,
                        color =  if ("dlon" in items) Color.Green else Color.Black
                    )
                    drawPath( //glowa
                        path = path10,
                        color = Color.LightGray
                    )
                    drawPath( //uda1
                        path = path11,
                        color =  if ("uda1" in items) Color.Green else Color.Black
                    )
                    drawPath( //uda4
                        path = path12,
                        color =  if ("uda4" in items) Color.Green else Color.Black
                    )
                    drawPath( //uda2
                        path = path13,
                        color =  if ("uda2" in items) Color.Green else Color.Black
                    )
                    drawPath( //uda3
                        path = path14,
                        color =  if ("uda3" in items) Color.Green else Color.Black
                    )
                    drawPath( //lydy1
                        path = path15,
                        color =  if ("lydy1" in items) Color.Green else Color.Black
                    )
                    drawPath( //lydy2
                        path = path16,
                        color =  if ("lydy2" in items) Color.Green else Color.Black
                    )
                    drawPath( //lydy3
                        path = path17,
                        color =  if ("lydy3" in items) Color.Green else Color.Black
                    )
                    drawPath( //stopap
                        path = path18,
                        color =  Color.LightGray
                    )
                    drawPath( //stopal
                        path = path19,
                        color =  Color.LightGray
                    )
                    drawPath( //przedramie_gorne
                        path = path20,
                        color =  if ("przedramie_gorne" in items) Color.Green else Color.Black
                    )
                    drawPath( //przedramie_dolne
                        path = path21,
                        color =  if ("przedramie_dolne" in items) Color.Green else Color.Black
                    )
                }

            }
        }
    )

}