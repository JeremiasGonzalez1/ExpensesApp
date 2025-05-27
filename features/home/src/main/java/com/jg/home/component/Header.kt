package com.jg.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    title: String,
    subtitle: String,
    onBackPressed: (() -> Unit)? = null
) {
    Box(modifier = Modifier.fillMaxWidth().height(62.dp).background(Color.Transparent), contentAlignment = Alignment.Center){
        Column(modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp, top = 20.dp ), horizontalAlignment = Alignment.Start  ) {
            Text(text = title, color = Color.Black, textAlign = TextAlign.Start, fontSize = 22.sp)
            Text(text = subtitle, color = Color.Black, textAlign = TextAlign.Start, fontSize = 16.sp)
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