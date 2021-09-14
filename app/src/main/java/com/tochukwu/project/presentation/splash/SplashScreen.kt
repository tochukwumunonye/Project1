package com.tochukwu.project.presentation.splash


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.*
import com.tochukwu.project.R
import com.tochukwu.project.presentation.util.Screen
import com.tochukwu.project.util.Constant
import com.tochukwu.project.util.Constant.SPLASH_SCREEN_DURATION


@Composable
fun SplashScreen(
   navController: NavController,
   dispatcher: CoroutineDispatcher = Dispatchers.Main
){
    val scale = remember{
        Animatable(0f)
    }

    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 5000,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(Constant.SPLASH_SCREEN_DURATION)
        navController.popBackStack()
        navController.navigate(Screen.LoginScreen.route)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}