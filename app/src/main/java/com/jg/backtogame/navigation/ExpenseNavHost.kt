package com.jg.backtogame.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jg.core.Route
import com.jg.home.HomeViewModel

@Composable
fun ExpenseNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.HomeScreen
    )
    {
        composable<Route.HomeScreen> {
            HomeScreen()
        }
    }
}