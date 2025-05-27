package com.jg.network.models

import java.util.Date

data class ExpenseDTO(
    val id:String,
    val name:String,
    val amount:Float,
    val date:Date
)
