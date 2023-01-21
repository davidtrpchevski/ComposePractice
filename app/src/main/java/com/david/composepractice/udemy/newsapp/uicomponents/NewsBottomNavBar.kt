package com.david.composepractice.udemy.newsapp.uicomponents

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.david.composepractice.udemy.newsapp.model.BottomNavigationDestination

@Composable
fun NewsAppBottomNavBar(
    navController: NavController, navigationEntriesList: List<BottomNavigationDestination>
) {
    BottomAppBar {
        val navigationEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navigationEntry?.destination?.route

        navigationEntriesList.forEach { bottomEntry ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = bottomEntry.icon, contentDescription = bottomEntry.title
                    )
                },
                label = { Text(text = bottomEntry.title) },
                selected = bottomEntry.route == currentRoute,
                onClick = {
                    navController.navigate(bottomEntry.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray
            )
        }
    }
}