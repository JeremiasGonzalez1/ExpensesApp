package com.jg.expenses.componet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun Budget(){
        Row(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary), horizontalArrangement = Arrangement.SpaceEvenly){
            BudgetItem(amount = 7000, label = "Total Balance", MaterialTheme.colorScheme.background, icon = Icons.Default.KeyboardArrowUp)
            VerticalDivider(modifier = Modifier.height(42.dp).width(2.dp).background(MaterialTheme.colorScheme.background))
            BudgetItem(amount = -23420, label = "Total Expense", MaterialTheme.colorScheme.secondary, icon= Icons.Default.KeyboardArrowDown)
        }
}

@Composable
fun BudgetItem(amount:Int, label:String, color: Color, icon:ImageVector){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround){
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary)
            Text(label, color = MaterialTheme.colorScheme.tertiary)
        }
        Text(text = "$$amount",  style = MaterialTheme.typography.titleLarge, color = color)
    }
}


@Preview
@Composable
fun BudgetPreview(){
    Budget()
}