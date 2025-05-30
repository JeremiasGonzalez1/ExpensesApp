package com.jg.network

import com.jg.entities.StatusResult
import com.jg.network.interfaces.BudgetDataSource
import com.jg.network.models.BudgetDTO
import io.ktor.client.call.body
import javax.inject.Inject

class BudgetDataSourceImpl @Inject constructor(private val baseClient: BaseClient) :
    BudgetDataSource {
    override suspend fun getBudget(): StatusResult<BudgetDTO> {
        val response = baseClient.get(
            url = "https://luksonexpense-back.onrender.com/api/v1/Budget/GetById",
            token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI4YzkwNTUzMC0zZTQyLTRkNDAtYTcwNS0wMDg4M2RiMzZlYjQiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJqZXJlbWlhc2dvbnphbGV6am9iQGdtYWlsLmNvbSIsImF1ZCI6Imx1a3NvbmV4cGVuc2UuY29tIiwiaXNzIjoibHVrc29uZXhwZW5zZS5jb20iLCJleHAiOjE3NDg0NjE0NjEsImlhdCI6MTc0ODQ2MTQ2MSwibmJmIjoxNzQ4NDYxNDYxfQ.Wacdb5P38giRYQUjbqE0Xjt7p5uXMmDISxJoyq8ZwBM"
        )
        try {
            response.httpResponse.let {
                if(it !=null)
                    return StatusResult.Success(it.body())
            }
            return StatusResult.Error(errorMessage = response.errorMessage)
        }catch (e:Exception){
            return StatusResult.Error(e.message.toString())
        }
    }
}
