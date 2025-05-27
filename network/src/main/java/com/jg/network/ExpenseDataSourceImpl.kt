package com.jg.network

import com.jg.entities.Expense
import com.jg.entities.StatusResult
import com.jg.network.interfaces.ExpenseDataSource
import com.jg.network.models.ExpenseDTO
import io.ktor.client.call.body
import javax.inject.Inject

class ExpenseDataSourceImpl @Inject constructor (private val baseClient: BaseClient) :
    ExpenseDataSource {

    override suspend fun createExpense(expense: Expense): StatusResult<ExpenseDTO> {
        val response = baseClient.post(url = "", value = expense, token = "")
        try{
            response.httpResponse.let {
                if (it!=null){
                    return StatusResult.Success(data = it.body())
                }
            }
            return StatusResult.Error(errorMessage = response.errorMessage)
        }catch (e:Exception){
            return StatusResult.Error(e.message.toString())
        }
    }

    override suspend fun getExpenses(): StatusResult<ExpenseDTO> {
        TODO("Not yet implemented")
    }
}
