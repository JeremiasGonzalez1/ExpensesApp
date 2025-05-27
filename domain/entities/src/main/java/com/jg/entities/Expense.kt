package com.jg.entities

import java.util.Date

data class Expense (
    val id:String,
    val name:String,
    val amount:Float,
    val date: Date
)