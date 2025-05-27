package com.jg.repositories

import com.jg.entities.Expense
import com.jg.entities.StatusResult

interface ExpenseRepository {
    suspend fun fetchExpenses(): StatusResult<List<Expense>>
    suspend fun createExpense(expense: Expense): StatusResult<Expense>
}