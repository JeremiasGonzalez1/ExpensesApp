package com.jg.data.repositories

import com.jg.network.interfaces.ExpenseDataSource
import com.jg.entities.Expense
import com.jg.entities.StatusResult
import com.jg.data.mapper.mapToExpense
import com.jg.repositories.ExpenseRepository
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(private val remoteDataSource: ExpenseDataSource):
    ExpenseRepository {

    override suspend fun fetchExpenses(): StatusResult<List<Expense>> {
        TODO("Not yet implemented")
    }

    override suspend fun createExpense(expense: Expense): StatusResult<Expense> {
        return when(val response = remoteDataSource.createExpense(expense)){
            is StatusResult.Success -> {
                StatusResult.Success(data = response.data.mapToExpense() )
            }
            is StatusResult.Error -> {
                StatusResult.Error(errorMessage = response.errorMessage)
            }
        }
    }
}