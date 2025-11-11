package com.example.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.lab13.ui.AnimatedVisibilityScreen
import com.example.lab13.ui.AnimateColorScreen
import com.example.lab13.ui.AnimateSizePositionScreen
import com.example.lab13.ui.AnimatedContentScreen
import com.example.lab13.ui.CombinedAnimationsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                //AnimatedVisibilityScreen()
                //AnimateColorScreen()
                //AnimateSizePositionScreen()
                //AnimatedContentScreen()
                CombinedAnimationsScreen()
            }
        }
    }
}
