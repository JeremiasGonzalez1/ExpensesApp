package com.jg.backtogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jg.backtogame.navigation.ExpenseNavHost
import com.jg.backtogame.ui.theme.BacktogameTheme
import com.jg.home.component.Header
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BacktogameTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { Header(title = "Hi, Welcome Back", subtitle = "Good morning", onBackPressed = {})},
                    contentColor = MaterialTheme.colorScheme.primary
                ){ contentPadding->
                    ExpenseNavHost()
                }
            }
        }
    }
}
