package com.jg.repositories

import com.jg.entities.Budget
import com.jg.entities.StatusResult

interface BudgetRepository {
    suspend fun getBudget(): StatusResult<Budget>
}