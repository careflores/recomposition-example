package com.example.recomposition

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    fun updateCounter() {
        _state.value = state.value.copy(counter = state.value.counter.plus(1))
    }

    fun updateSlider(value: Int) {
        _state.value = state.value.copy(sliderValue = value)
    }
}

data class MainState(
    val sliderValue: Int = 0,
    val counter: Int = 0
)
