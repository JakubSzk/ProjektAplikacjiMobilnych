package com.example.gymbro.ui.theme.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gymbro.ui.theme.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MuscleViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MuscleViewModel(application) as T
    }
}

class MuscleRepository(muscleDaoo: MuscleDao) {
    private val muscleDao: MuscleDao = muscleDaoo

    fun getMuscle(): Flow<List<MuscleElement>> {
        return muscleDao.getMuscle()
    }

    suspend fun insert(muscle: MuscleElement) {
        muscleDao.insertMuscle(muscle)
    }

    suspend fun deleteAll() {
        muscleDao.deleteAllMuscles()
    }

    suspend fun update(muscle: MuscleElement) {
        muscleDao.updateMuscle(muscle)
    }

    suspend fun delete(muscle: MuscleElement) {
        muscleDao.deleteMuscle(muscle)
    }
}
class MuscleViewModel(application: Application) : ViewModel() {

    private val repository: MuscleRepository
    private val _muscleState = MutableStateFlow<List<MuscleElement>>(emptyList())
    val usersState: StateFlow<List<MuscleElement>>
        get() = _muscleState

    init {
        val db = MuscleDatabase.getDatabase(application)
        val dao = db.muscleDao()
        repository = MuscleRepository(dao)

        fetchMuscle()
    }

    private fun fetchMuscle() {
        viewModelScope.launch {
            repository.getMuscle().collect { muscle ->
                _muscleState.value = muscle
            }
        }
    }

    fun clearMuscle() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
    fun deleteMuscleElement(muscle: MuscleElement) {
        viewModelScope.launch {
            repository.delete(muscle)
        }
    }

    fun addMuscleElement(muscle: MuscleElement) {
        viewModelScope.launch {
            repository.insert(muscle)
        }
    }

    fun updateMuscleElement(muscle: MuscleElement) {
        viewModelScope.launch {
            repository.update(muscle)
        }
    }
}