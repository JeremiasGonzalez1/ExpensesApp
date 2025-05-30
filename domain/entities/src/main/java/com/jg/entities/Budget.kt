package com.jg.entities

data class Budget(
    val budgetId: String,
    val budgetName: String,
    val budgetDescription: String,
    val period: String,
    val amount: Int,
    val expenses: List<Expense> ? = null
)

