package com.jg.data.repositories

import com.jg.entities.Budget
import com.jg.entities.Expense
import com.jg.entities.StatusResult
import com.jg.network.interfaces.BudgetDataSource
import com.jg.repositories.BudgetRepository
import javax.inject.Inject

class BudgetRepositoryImpl @Inject constructor(private val dataSource : BudgetDataSource): BudgetRepository {
    override suspend fun getBudget(): StatusResult<Budget> {
        return when (val response = dataSource.getBudget()){
            is StatusResult.Error -> {
                StatusResult.Error(response.errorMessage)
            }
            is StatusResult.Success -> {
                StatusResult.Success(
                    response.data.let {
                        Budget(
                            budgetId = it.budgetId,
                            budgetName = it.budgetName,
                            budgetDescription = it.budgetDescription,
                            period = it.period,
                            amount = it.amount,
                            expenses = it.expenses.map { item ->
                                Expense(
                                    id = item.id,
                                    name = item.name,
                                    amount = item.amount,
                                    date = item.date
                                )
                            }
                        )
                    }
                )
            }
        }
    }

}