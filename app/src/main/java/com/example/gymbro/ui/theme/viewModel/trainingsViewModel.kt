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

class TrainingViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TrainingViewModel(application) as T
    }
}

class TrainingRepository(trainingDaoo: TrainingDao) {
    private val trainingDao: TrainingDao = trainingDaoo

    fun getTraining(): Flow<List<TrainingElement>> {
        return trainingDao.getTraining()
    }

    suspend fun insert(training: TrainingElement) {
        trainingDao.insert(training)
    }

    suspend fun deleteAll() {
        trainingDao.deleteAll()
    }

    suspend fun update(training: TrainingElement) {
        trainingDao.update(training)
    }

    suspend fun delete(training: TrainingElement) {
        trainingDao.delete(training)
    }
}
class TrainingViewModel(application: Application) : ViewModel() {

    private val repository: TrainingRepository
    private val _trainingState = MutableStateFlow<List<TrainingElement>>(emptyList())
    val usersState: StateFlow<List<TrainingElement>>
        get() = _trainingState

    init {
        val db = TrainingDatabase.getDatabase(application)
        val dao = db.trainingDao()
        repository = TrainingRepository(dao)

        fetchTraining()
    }

    private fun fetchTraining() {
        viewModelScope.launch {
            repository.getTraining().collect { training ->
                _trainingState.value = training
            }
        }
    }

    fun clearTraining() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
    fun deleteTrainingElement(training: TrainingElement) {
        viewModelScope.launch {
            repository.delete(training)
        }
    }

    fun addTrainingElement(training: TrainingElement) {
        viewModelScope.launch {
            repository.insert(training)
        }
    }

    fun updateTrainingElement(training: TrainingElement) {
        viewModelScope.launch {
            repository.update(training)
        }
    }
}