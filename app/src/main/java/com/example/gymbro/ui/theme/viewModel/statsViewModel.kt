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

class StatsViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StatsViewModel(application) as T
    }
}

class StatsRepository(statsDaoo: StatsDao) {
    private val statsDao: StatsDao = statsDaoo

    fun getStats(): Flow<List<StatsElement>> {
        return statsDao.getStats()
    }

    suspend fun insert(stats: StatsElement) {
        statsDao.insert(stats)
    }

    suspend fun deleteAll() {
        statsDao.deleteAll()
    }

    suspend fun update(stats: StatsElement) {
        statsDao.update(stats)
    }

    suspend fun delete(stats: StatsElement) {
        statsDao.delete(stats)
    }
}
class StatsViewModel(application: Application) : ViewModel() {

    private val repository: StatsRepository
    private val _statsState = MutableStateFlow<List<StatsElement>>(emptyList())
    val usersState: StateFlow<List<StatsElement>>
        get() = _statsState

    init {
        val db = StatsDatabase.getDatabase(application)
        val dao = db.statsDao()
        repository = StatsRepository(dao)

        fetchStats()
    }

    private fun fetchStats() {
        viewModelScope.launch {
            repository.getStats().collect { stats ->
                _statsState.value = stats
            }
        }
    }

    fun clearStats() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
    fun deleteStatsElement(stats: StatsElement) {
        viewModelScope.launch {
            repository.delete(stats)
        }
    }

    fun addStatsElement(stats: StatsElement) {
        viewModelScope.launch {
            repository.insert(stats)
        }
    }

    fun updateStatsElement(stats: StatsElement) {
        viewModelScope.launch {
            repository.update(stats)
        }
    }
}