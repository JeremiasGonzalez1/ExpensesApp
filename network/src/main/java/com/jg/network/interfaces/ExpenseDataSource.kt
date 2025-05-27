package com.jg.network.interfaces

import com.jg.entities.Expense
import com.jg.entities.StatusResult
import com.jg.network.models.ExpenseDTO


interface ExpenseDataSource {
    suspend fun createExpense (expense: Expense): StatusResult<ExpenseDTO>
    suspend fun getExpenses(): StatusResult<ExpenseDTO>
}