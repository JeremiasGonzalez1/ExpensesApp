package com.jg.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    title: String,
    subtitle: String,
    onBackPressed: (() -> Unit)? = null
) {
    Row(modifier = Modifier.fillMaxWidth().height(82.dp).background(MaterialTheme.colorScheme.primary), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
        Column(modifier = Modifier.padding(start = 20.dp), horizontalAlignment = Alignment.Start  ) {
            Text(text = title, textAlign = TextAlign.Start, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.tertiary)
            Text(text = subtitle,  textAlign = TextAlign.Start, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.tertiary)
        }
        IconButton(onClick = {}, modifier = Modifier.size(30.dp).offset(x = (-36).dp, y = 0.dp)) {
            Icon(imageVector = Icons.Default.Notifications, tint = MaterialTheme.colorScheme.background, contentDescription = "Back",)
        }
    }

}

@Preview
@Composable
fun HeaderPreview() {
    Header(
        title = "Home, welcome to the app",
        subtitle = "Good morning",
        onBackPressed = null
    )
}