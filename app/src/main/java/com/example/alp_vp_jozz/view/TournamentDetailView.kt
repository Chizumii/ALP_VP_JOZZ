package com.example.alp_vp_jozz.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun TournamentDetailView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF222222))
    ) {
        // Navbar atas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter) // Pastikan berada di bagian atas
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
                    Spacer(modifier = Modifier.weight(1f)) // Spacer untuk merenggangkan konten
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
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 90.dp, bottom = 80.dp, start = 16.dp, end = 16.dp)
        ) {
            // Title
            Text(
                text = "DKI Jakarta Champion Tournament",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Image
            Image(
                painter = painterResource(id = R.drawable.tournament), // Replace with your drawable ID
                contentDescription = "Tournament Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Gray)
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            // Description Section
            Text(
                text = "Description",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Information Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Biaya Pendaftaran",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Rp 20.000",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                Column {
                    Text(
                        text = "Lokasi",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Jakarta",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Rules",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "BO 3",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF448AFF), // Warna background biru
                            shape = RoundedCornerShape(8.dp) // Membuat sudut melengkung
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp) // Padding di dalam kotak
                        .clickable {
                            // TODO: Tambahkan aksi klik di sini
                        },
                    contentAlignment = Alignment.Center // Konten di tengah
                ) {
                    Text(
                        text = "Register",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
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
fun TournamentDetailViewPreview() {
    TournamentDetailView()
}