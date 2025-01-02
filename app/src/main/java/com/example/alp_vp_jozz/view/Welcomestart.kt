package com.example.alp_vp_jozz.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp_jozz.R

@Composable
fun Welcomestart() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF222222))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0XFF222222)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Logo di kiri
                Image(
                    painter = painterResource(R.drawable.community_removebg_preview),
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Welcome, @DearUser",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFF222222)) // Set background color; replace with an image later
        ) {
            // Center column for text and button
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO: Add navigation logic */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A00FF))
                ) {
                    Text(
                        text = "Get Started",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Bottom navigation bar
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .background(Color(0XFF222222))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Spacer(modifier = Modifier.padding(start = 5.dp))

                        Image(
                            painter = painterResource(id = R.drawable.baseline_home_filled_24),
                            contentDescription = "home",
                            modifier = Modifier.size(40.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = "search",
                            modifier = Modifier.size(40.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.champion),
                            contentDescription = "champion",
                            modifier = Modifier.size(40.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.baseline_groups_24),
                            contentDescription = "team",
                            modifier = Modifier.size(40.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "profile",
                            modifier = Modifier.size(40.dp)
                        )

                        Spacer(modifier = Modifier.padding(end = 5.dp))
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WelcomestartPreview() {
    Welcomestart()
}
