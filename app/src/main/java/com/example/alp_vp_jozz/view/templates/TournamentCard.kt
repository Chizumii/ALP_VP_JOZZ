package com.example.alp_vp_jozz.view.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
fun TorunamentCard() {
    Card(

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tournament), // Ganti dengan ID gambar Anda
                    contentDescription = "Esports Background",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = "DKI Jakarta Championship",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "📅 12 - 18 Desember 2024",
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun TorunamentCardPreview() {
    TorunamentCard()
}