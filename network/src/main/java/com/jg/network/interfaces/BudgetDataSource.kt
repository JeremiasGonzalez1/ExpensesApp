package com.jg.network.interfaces

import com.jg.entities.StatusResult
import com.jg.network.models.BudgetDTO

interface BudgetDataSource {
    suspend fun getBudget():StatusResult<BudgetDTO>
}