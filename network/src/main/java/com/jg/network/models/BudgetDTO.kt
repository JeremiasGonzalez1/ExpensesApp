package com.jg.network.models

import kotlinx.serialization.Serializable

@Serializable
data class BudgetDTO (
    val budgetId: String,
    val budgetName: String,
    val budgetDescription: String,
    val period: String,
    val amount: Int,
    val expenses: List<ExpenseDTO>
)