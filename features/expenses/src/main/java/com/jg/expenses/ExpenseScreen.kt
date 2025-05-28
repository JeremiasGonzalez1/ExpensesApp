package com.jg.expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jg.expenses.componet.Budget

@Composable
fun ExpenseScreen() {
Box(modifier = Modifier.fillMaxSize().offset(x=0.dp, y = 80.dp).background(MaterialTheme.colorScheme.primary)) {
    Budget() }
}