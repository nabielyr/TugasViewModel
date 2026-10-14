package com.example.tugasviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

    // State internal yang bersifat mutable (bisa diubah di dalam ViewModel)
    private val _uiState = MutableStateFlow(AppUiState())

    // Backing property yang bersifat read-only untuk diakses oleh UI
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    init {
        reset()
    }

    // Fungsi untuk tombol Up (menambah nilai counter sebanyak 1)
    fun addCounter() {
        val count = _uiState.value.counter + 1
        _uiState.update { currentState ->
            currentState.copy(
                counter = count
            )
        }
    }

    // Fungsi untuk tombol Down (mengurangi nilai counter sebanyak 1)
    fun subCounter() {
        val count = _uiState.value.counter - 1
        _uiState.update { currentState ->
            currentState.copy(
                counter = count
            )
        }
    }

    // Fungsi untuk tombol Reset (mengembalikan nilai counter ke 0)
    fun reset() {
        _uiState.value = AppUiState(counter = 0)
    }
}