package com.example.gymbro.ui.theme.model
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymbro.ui.theme.viewModel.MuscleViewModel
import com.example.gymbro.ui.theme.viewModel.MuscleViewModelFactory

//it should only be used once in program or it could fuck with SQL hierarchy
@Composable
fun InitiateMusclesIfNotExist()
{
    val viewModel: MuscleViewModel = viewModel(
        LocalViewModelStoreOwner.current!!,
        "UserViewModel",
        MuscleViewModelFactory(LocalContext.current.applicationContext as Application)
    )
    LaunchedEffect(Unit) {


        //first check if there are any muscles in database
        //I won't add clearing function because it shouldn't be used
        viewModel.isItEmpty()
        if (viewModel.emptyBool) {
            viewModel.addMuscleElement(MuscleElement(0, "klata_gora"))
            viewModel.addMuscleElement(MuscleElement(1, "klata_dol"))
            viewModel.addMuscleElement(MuscleElement(2, "barki"))
            viewModel.addMuscleElement(MuscleElement(3, "szyja"))
            viewModel.addMuscleElement(MuscleElement(4, "brzuch"))
            viewModel.addMuscleElement(MuscleElement(5, "boki"))
            viewModel.addMuscleElement(MuscleElement(6, "ramie"))
            viewModel.addMuscleElement(MuscleElement(7, "barki_szersze"))
            viewModel.addMuscleElement(MuscleElement(8, "triceps"))
            viewModel.addMuscleElement(MuscleElement(9, "biceps"))
            viewModel.addMuscleElement(MuscleElement(10, "przedramie_gorne"))
            viewModel.addMuscleElement(MuscleElement(11, "przedramie_dolne"))
            viewModel.addMuscleElement(MuscleElement(12, "dlon"))
            viewModel.addMuscleElement(MuscleElement(13, "uda1"))
            viewModel.addMuscleElement(MuscleElement(14, "uda2"))
            viewModel.addMuscleElement(MuscleElement(15, "uda3"))
            viewModel.addMuscleElement(MuscleElement(16, "uda4"))
            viewModel.addMuscleElement(MuscleElement(17, "lydy1"))
            viewModel.addMuscleElement(MuscleElement(18, "lydy2"))
            viewModel.addMuscleElement(MuscleElement(19, "lydy3"))
            viewModel.addMuscleElement(MuscleElement(20, "gorne_plecy"))
            viewModel.addMuscleElement(MuscleElement(21, "plecy_srodek_wieksze"))
            viewModel.addMuscleElement(MuscleElement(22, "plecy"))
            viewModel.addMuscleElement(MuscleElement(23, "plecy_srodek"))
            viewModel.addMuscleElement(MuscleElement(24, "tric1"))
            viewModel.addMuscleElement(MuscleElement(25, "tric2"))
            viewModel.addMuscleElement(MuscleElement(26, "tric3"))
            viewModel.addMuscleElement(MuscleElement(27, "plecy_dol"))
            viewModel.addMuscleElement(MuscleElement(28, "przedramie1"))
            viewModel.addMuscleElement(MuscleElement(29, "przedramie2"))
            viewModel.addMuscleElement(MuscleElement(30, "posladki_gorne"))
            viewModel.addMuscleElement(MuscleElement(31, "posladki"))
            viewModel.addMuscleElement(MuscleElement(32, "uda_male"))
            viewModel.addMuscleElement(MuscleElement(33, "uda_srednie"))
            viewModel.addMuscleElement(MuscleElement(34, "uda_duze"))
            viewModel.addMuscleElement(MuscleElement(35, "lydki1"))
            viewModel.addMuscleElement(MuscleElement(36, "lydki2"))
        }
    }
}

