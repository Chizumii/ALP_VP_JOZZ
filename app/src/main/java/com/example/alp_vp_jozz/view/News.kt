package com.example.alp_vp_jozz.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

// Data class for News
data class NewsItem(
    val imageRes: Int,
    val title: String,
    val description: String
)

@Composable
fun NewsScreen(
    newsList: List<NewsItem>,
    onCreateNewsClick: () -> Unit,
    modifier: Modifier = Modifier
)
 {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF222222))
    ) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF222222)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.community_removebg_preview),
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "News",
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

        // News List Section
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            items(newsList) { news ->
                NewsItemView(newsItem = news)
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }

        // Tombol Create News
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Button(
                onClick = { onCreateNewsClick() },
                modifier = Modifier.fillMaxWidth(),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFF5A5AFF))
            ) {
                Text(text = "Create News", color = Color.White)
            }
        }

        // Bottom Navigation
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF222222))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                val icons = listOf(
                    R.drawable.baseline_home_filled_24 to "Home",
                    R.drawable.baseline_search_24 to "Search",
                    R.drawable.champion to "Champion",
                    R.drawable.baseline_groups_24 to "Team",
                    R.drawable.baseline_person_24 to "Profile"
                )
                icons.forEach { (iconRes, description) ->
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = description,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun NewsItemView(newsItem: NewsItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(newsItem.imageRes),
            contentDescription = newsItem.title,
            modifier = Modifier
                .size(120.dp)
                .padding(end = 20.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            Text(
                text = newsItem.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = newsItem.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    val previewNewsList = List(1) { index ->
        NewsItem(
            imageRes = R.drawable.shortnsweet, // Replace with a valid drawable
            title = "News Title $index",
            description = "Description for News $index"
        )
    }
    NewsScreen(
        newsList = previewNewsList,
        onCreateNewsClick = {}
    )
}
