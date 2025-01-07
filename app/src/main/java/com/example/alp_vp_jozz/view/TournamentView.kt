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
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.alp_vp_jozz.view.templates.TorunamentCard

@Composable
fun TournamentView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF222222))
    ) {
        // Navbar atas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
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
                    text = "Tournament",
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
        }

        // LazyColumn dengan padding untuk menyesuaikan posisi
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 90.dp,
                    bottom = 80.dp,
                    start = 16.dp,
                    end = 16.dp
                ) // Beri ruang untuk navbar atas dan bawah
        ) {
            items(5) { // Misalnya 5 kartu turnamen
                TorunamentCard(tournamentName = "1",
                    tournamentDate = "1",
                    onCardClick = {})
                Spacer(modifier = Modifier.height(16.dp)) // Jarak antar kartu
            }
        }

        // Navbar bawah
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Posisi navbar di bawah
                .background(Color(0XFF222222))
        ) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
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
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TournamentViewPreview() {
    TournamentView()
}