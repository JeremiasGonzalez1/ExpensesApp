package com.jg.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jg.entities.Expense
import com.jg.entities.StatusResult
import com.jg.usecases.CreateExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class HomeUIState{
    data object IDLE: HomeUIState()
    data object Loading : HomeUIState()
    data class Error(val message:String) : HomeUIState()
    data class Success(val expense: Expense) : HomeUIState()
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val createExpense: CreateExpenseUseCase): ViewModel(){

    private val _responseCreateExpense = MutableStateFlow<HomeUIState>(HomeUIState.IDLE)
    val responseCreateExpense = _responseCreateExpense.asStateFlow()

    fun createExpense(expense:Expense){
        _responseCreateExpense.value = HomeUIState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = createExpense.invoke(expense)){
                is StatusResult.Error -> _responseCreateExpense.value = HomeUIState.Error(response.errorMessage)
                is StatusResult.Success -> _responseCreateExpense.value = HomeUIState.Success(response.data)
            }
        }
    }

    fun getBudgets(){

    }

}