package com.example.alp_vp_jozz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.alp_vp_jozz.navigation.AppRouting
import com.example.alp_vp_jozz.ui.theme.ALP_VP_JOZZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ALP_VP_JOZZTheme {
                AppRouting()
            }
        }
    }
}
