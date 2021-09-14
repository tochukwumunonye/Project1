package com.tochukwu.project.presentation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.tochukwu.project.presentation.ui.theme.ProjectTheme
import com.tochukwu.project.presentation.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ProjectTheme {
                Surface(
                    color =    MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Navigation()
                }

            }
        }
    }
}



/**
 *


@AndroidEntryPoint

Surface(
color = MaterialTheme.colors.background,
modifier = Modifier.fillMaxSize()
) {
val navController = rememberNavController()
val navBackStackEntry by navController.currentBackStackEntryAsState()
StandardScaffold(
navController = navController,
showBottomBar = navBackStackEntry?.destination?.route in listOf(
Screen.MainFeedScreen.route,
Screen.ChatScreen.route,
Screen.ActivityScreen.route,
Screen.ProfileScreen.route,
),
modifier = Modifier.fillMaxSize(),
onFabClick = {
navController.navigate(Screen.CreatePostScreen.route)
}
) {
Navigation(navController)
}
}
}
}
}
}**/