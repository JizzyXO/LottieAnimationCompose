package com.example.lottieanimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimationcompose.ui.theme.LottieAnimationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieAnimationComposeTheme {
                val composition by rememberLottieComposition(
                    spec = (LottieCompositionSpec.Asset("anim.json"))
                )
                var isPlaying by remember{
                    mutableStateOf(false)
                }


                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LottieAnimation(modifier = Modifier
                        .width(300.dp)
                        .height(300.dp),
                        composition = composition,
                        isPlaying = isPlaying,
                        speed = 3f,
                        iterations = LottieConstants.IterateForever
                    )
                    Button(
                        onClick = {
                            isPlaying = true
                        }) {
                        Text(text = "Play anim")
                    }
                }
            }
        }
    }
}