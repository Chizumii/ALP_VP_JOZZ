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
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp_jozz.R

@Composable
fun ProfileEdit() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF222222))
    ) {
        // Header
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

        // Edit Profile Section
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Profile Image
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .clickable { /* Add image picker */ },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_camera),
                    contentDescription = "Edit Photo",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            val nickname = remember { mutableStateOf(TextFieldValue("")) }
            val firstName = remember { mutableStateOf(TextFieldValue("")) }
            val lastName = remember { mutableStateOf(TextFieldValue("")) }
            val phoneNumber = remember { mutableStateOf(TextFieldValue("")) }

            EditTextField(value = nickname.value, onValueChange = { nickname.value = it }, label = "Nickname")
            Spacer(modifier = Modifier.height(8.dp))
            EditTextField(value = firstName.value, onValueChange = { firstName.value = it }, label = "Nama Depan")
            Spacer(modifier = Modifier.height(8.dp))
            EditTextField(value = lastName.value, onValueChange = { lastName.value = it }, label = "Nama Belakang")
            Spacer(modifier = Modifier.height(8.dp))
            EditTextField(value = phoneNumber.value, onValueChange = { phoneNumber.value = it }, label = "Nomor Telepon")

            Spacer(modifier = Modifier.height(24.dp))

            // Save Button
            Button(
                onClick = { /* Save profile logic */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFF8187DC))
            ) {
                Text(text = "Save", color = Color.White, fontSize = 16.sp)
            }
        }
    }

    // Bottom Navigation Bar
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

@Composable
fun EditTextField(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit, label: String) {
    Column {
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 14.sp
        )
        androidx.compose.foundation.text.BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2E2E2E), shape = RoundedCornerShape(8.dp))
                .padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileEditPreview() {
    ProfileEdit()
}
