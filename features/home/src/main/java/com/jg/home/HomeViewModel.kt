package com.jg.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jg.entities.Budget
import com.jg.entities.Expense
import com.jg.entities.StatusResult
import com.jg.usecases.CreateExpenseUseCase
import com.jg.usecases.GetBudgetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class  HomeUIState <out T> {
    data object IDLE: HomeUIState<Nothing>()
    data object Loading : HomeUIState<Nothing>()
    data class Error(val message:String) : HomeUIState<Nothing>()
    data class Success <out T>(val expense: T) : HomeUIState<T>()
}
@HiltViewModel
class HomeViewModel @Inject constructor(private val createExpense: CreateExpenseUseCase, private val getBudgetUseCase: GetBudgetUseCase): ViewModel(){

    private val _responseCreateExpense = MutableStateFlow<HomeUIState<Expense>>(HomeUIState.IDLE)
    val responseCreateExpense = _responseCreateExpense.asStateFlow()

    private val _budgetResponse = MutableStateFlow<HomeUIState<Budget>>(HomeUIState.IDLE)
    val budgetResponse = _responseCreateExpense.asStateFlow()


    init {
        getBudget()
    }

    fun createExpense(expense:Expense){
        _responseCreateExpense.value = HomeUIState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = createExpense.invoke(expense)){
                is StatusResult.Error -> _responseCreateExpense.value = HomeUIState.Error(response.errorMessage)
                is StatusResult.Success -> _responseCreateExpense.value = HomeUIState.Success(response.data)
            }
        }
    }

    private fun getBudget(){
        _budgetResponse.value = HomeUIState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _budgetResponse.value = when(val response = getBudgetUseCase.invoke()){
                is StatusResult.Error -> HomeUIState.Error(response.errorMessage)
                is StatusResult.Success -> HomeUIState.Success(response.data)
            }
        }
    }

}