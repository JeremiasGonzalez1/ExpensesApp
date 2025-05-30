package com.jg.usecases

import com.jg.repositories.BudgetRepository
import javax.inject.Inject

class GetBudgetUseCase @Inject constructor(private val budgetRepository: BudgetRepository) {
    suspend fun invoke() = budgetRepository.getBudget()
}