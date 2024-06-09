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

class ExerciseViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExerciseViewModel(application) as T
    }
}

class ExerciseRepository(exerciseDaoo: ExerciseDao) {
    private val exerciseDao: ExerciseDao = exerciseDaoo

    fun getExercise(): Flow<List<ExerciseElement>> {
        return exerciseDao.getExercise()
    }

    fun getExercise2(): Flow<List<ExerciseElement>> {
        return exerciseDao.getExercise2()
    }


    suspend fun insert(exercise: ExerciseElement) {
        exerciseDao.insert(exercise)
    }

    suspend fun deleteAll() {
        exerciseDao.deleteAll()
    }

    suspend fun update(exercise: ExerciseElement) {
        exerciseDao.update(exercise)
    }

    suspend fun delete(exercise: ExerciseElement) {
        exerciseDao.delete(exercise)
    }
}
class ExerciseViewModel(application: Application) : ViewModel() {

    private val repository: ExerciseRepository
    private val _exerciseState = MutableStateFlow<List<ExerciseElement>>(emptyList())
    val usersState: StateFlow<List<ExerciseElement>>
        get() = _exerciseState

    init {
        val db = ExerciseDatabase.getDatabase(application)
        val dao = db.exerciseDao()
        repository = ExerciseRepository(dao)

        fetchExercise()
    }

    private fun fetchExercise() {
        viewModelScope.launch {
            repository.getExercise().collect { exercise ->
                _exerciseState.value = exercise
            }
        }
    }
    fun fetchExercise2() {
        viewModelScope.launch {
            repository.getExercise2().collect { exercise ->
                _exerciseState.value = exercise
            }
        }
    }

    fun clearExercise() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
    fun deleteExerciseElement(exercise: ExerciseElement) {
        viewModelScope.launch {
            repository.delete(exercise)
        }
    }

    fun addExerciseElement(exercise: ExerciseElement) {
        viewModelScope.launch {
            repository.insert(exercise)
        }
    }

    fun updateExerciseElement(exercise: ExerciseElement) {
        viewModelScope.launch {
            repository.update(exercise)
        }
    }
}