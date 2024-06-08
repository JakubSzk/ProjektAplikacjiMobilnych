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

class AchiveViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AchiveViewModel(application) as T
    }
}

class AchiveRepository(achiveDaoo: AchiveDao) {
    private val achiveDao: AchiveDao = achiveDaoo

    fun getAchive(): Flow<List<AchiveElement>> {
        return achiveDao.getAchive()
    }

    suspend fun insert(achive: AchiveElement) {
        achiveDao.insert(achive)
    }

    suspend fun deleteAll() {
        achiveDao.deleteAll()
    }

    suspend fun update(achive: AchiveElement) {
        achiveDao.update(achive)
    }

    suspend fun delete(achive: AchiveElement) {
        achiveDao.delete(achive)
    }
}
class AchiveViewModel(application: Application) : ViewModel() {

    private val repository: AchiveRepository
    private val _achiveState = MutableStateFlow<List<AchiveElement>>(emptyList())
    val usersState: StateFlow<List<AchiveElement>>
        get() = _achiveState

    init {
        val db = AchiveDatabase.getDatabase(application)
        val dao = db.achiveDao()
        repository = AchiveRepository(dao)

        fetchAchive()
    }

    private fun fetchAchive() {
        viewModelScope.launch {
            repository.getAchive().collect { achive ->
                _achiveState.value = achive
            }
        }
    }

    fun clearAchive() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
    fun deleteAchiveElement(achive: AchiveElement) {
        viewModelScope.launch {
            repository.delete(achive)
        }
    }

    fun addAchiveElement(achive: AchiveElement) {
        viewModelScope.launch {
            repository.insert(achive)
        }
    }

    fun updateAchiveElement(achive: AchiveElement) {
        viewModelScope.launch {
            repository.update(achive)
        }
    }
}