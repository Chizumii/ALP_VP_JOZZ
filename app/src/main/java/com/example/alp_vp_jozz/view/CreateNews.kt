package com.example.alp_vp_jozz.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.alp_vp_jozz.R
import com.example.alp_vp_jozz.viewModels.NewsViewModel

@Composable
fun CreateNewsScreen(
    navController: NavController,
    newsViewModel: NewsViewModel
) {
    var titleInput by remember { mutableStateOf(newsViewModel.titleInput) }
    var descriptionInput by remember { mutableStateOf(newsViewModel.descriptionInput) }
    var authorInput by remember { mutableStateOf(newsViewModel.authorInput) }
    var imageInput by remember { mutableStateOf(newsViewModel.imageInput) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            uri?.let { newValue ->
                imageInput = newValue.toString()
                newsViewModel.updateImageInput(imageInput)
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222222))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF333333))
                .padding(vertical = 8.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.community_removebg_preview),
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Create News",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Create News Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color(0xFF333333), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Create News",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Title Input
                CustomTextField(
                    value = titleInput,
                    onValueChange = {
                        titleInput = it
                        newsViewModel.updateTitleInput(it)
                    },
                    label = "Title"
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Description Input
                CustomTextField(
                    value = descriptionInput,
                    onValueChange = {
                        descriptionInput = it
                        newsViewModel.updateDescriptionInput(it)
                    },
                    label = "Description",
                    maxLines = 3
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Author Input
                CustomTextField(
                    value = authorInput,
                    onValueChange = {
                        authorInput = it
                        newsViewModel.updateAuthorInput(it)
                    },
                    label = "Author"
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Image Upload Section
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .background(
                            color = Color(0xFF2D2D2D),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (imageInput != null) {
                        Image(
                            painter = rememberAsyncImagePainter(newsViewModel.imageInput),
                            contentDescription = "News Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp))
                        )
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(R.drawable.community_removebg_preview),
                                contentDescription = "Upload Icon",
                                modifier = Modifier.size(48.dp)
                            )
                            Text(
                                text = "Upload News Image",
                                color = Color.White,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }

                Button(
                    onClick = { launcher.launch("image/*") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A90E2)),
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(
                        text = "Choose Image",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Submit Button
                Button(
                    onClick = {
                        newsViewModel.createNews(
                            navController,
                            titleInput,
                            descriptionInput,
                            authorInput,
                            imageInput
                        )
                        navController.navigate("News")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE53935)
                    ),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = "Create News",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    maxLines: Int = 1
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2D2D2D), RoundedCornerShape(12.dp)),
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp
            ),
            maxLines = maxLines,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF4A90E2),
                unfocusedBorderColor = Color(0xFF404040),
                cursorColor = Color(0xFF4A90E2)
            )
        )
    }
}
