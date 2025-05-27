package com.jg.usecases

import com.jg.entities.Expense
import com.jg.repositories.ExpenseRepository

import javax.inject.Inject

class CreateExpenseUseCase @Inject constructor (private val repository : ExpenseRepository) {
    suspend fun invoke(expense: Expense) = repository.createExpense(expense)
}