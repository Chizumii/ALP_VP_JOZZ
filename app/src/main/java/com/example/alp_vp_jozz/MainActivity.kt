package com.example.alp_vp_jozz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alp_vp_jozz.ui.theme.ALP_VP_JOZZTheme
import com.example.alp_vp_jozz.view.EsHype

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ALP_VP_JOZZTheme {
                EsHype()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ALP_VP_JOZZTheme {
        EsHype()
    }
}