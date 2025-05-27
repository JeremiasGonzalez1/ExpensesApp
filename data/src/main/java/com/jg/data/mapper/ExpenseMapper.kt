package com.jg.data.mapper

import com.jg.entities.Expense
import com.jg.network.models.ExpenseDTO

fun ExpenseDTO.mapToExpense():Expense{
    val expense = Expense(
        id = this.id,
        name = this.name,
        amount = this.amount,
        date = this.date
    )
    return  expense
}