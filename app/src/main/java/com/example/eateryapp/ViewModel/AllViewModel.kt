package com.example.eateryapp.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TotalValue : ViewModel() {
    // Using StateFlow
    private val _totalValue = MutableStateFlow(0)
    val totalValue: StateFlow<Int> = _totalValue

    // Using MutableState
    private val _totalValueState = mutableStateOf(0)
    val totalValueState: MutableState<Int> = _totalValueState

    fun increase(amount: Int) {
        _totalValue.value += amount
        _totalValueState.value += amount
    }
    fun decrement(amount: Int) {
        _totalValue.value -= amount
        _totalValueState.value -= amount
    }
}
