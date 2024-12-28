package com.example.alp_vp_jozz.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp_jozz.R

@Composable
fun ProfileView() {
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
                text = "Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(36.dp))
        // User Profile Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with actual image resource
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24), // Replace with pencil icon resource
                    contentDescription = "Edit Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { /* Handle edit action */ },
                    tint = Color.Blue
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Delvincent Patricio",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "089690387887",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Team",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle team click action */ }
                .padding(16.dp)
                .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with actual team image resource
                    contentDescription = "Team Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Mobile Legend",
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Start,
                        color = Color.Gray
                    )
                    Text(
                        text = "Delvin Mekanik Tua",
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Game Profile Section
        Text(
            text = "Profile Game",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Mobile Legend",
                fontWeight = FontWeight.Medium,
                color = Color(0XFF8FACE7)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(), // Tambahkan padding untuk memberikan ruang di sekitar Row
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f) // Membagi lebar secara proporsional
                        .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "In-Game Nickname",
                            textAlign = TextAlign.Start,
                            color = Color.Gray
                        )
                        Text(
                            text = "Chizumi",
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp)) // Tambahkan spacer untuk jarak antar Box
                Box(
                    modifier = Modifier
                        .weight(1f) // Membagi lebar secara proporsional
                        .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Game Id",
                            textAlign = TextAlign.Start,
                            color = Color.Gray
                        )
                        Text(
                            text = "427877263",
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                    }
                }
            }

        }

        // Edit Name Dialo
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

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


@Preview(showBackground = true)
@Composable
fun ProfileViewPreview() {
    ProfileView()
}
