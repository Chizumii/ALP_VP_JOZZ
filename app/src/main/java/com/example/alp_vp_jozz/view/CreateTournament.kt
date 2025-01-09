package com.example.alp_vp_jozz.view

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.alp_vp_jozz.R
import com.example.alp_vp_jozz.viewmodels.TournamentViewModel

@Composable
fun CreateTournament(
    tournamentViewModel: TournamentViewModel,
    modifier: Modifier,
    navController: NavHostController,
    token: String,
) {
    val availableLocations = listOf(tournamentViewModel.lokasiInput)

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            uri?.let {
                    newValue ->
                tournamentViewModel.imageInput= newValue.toString()
            }
        }
    )
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
                Image(
                    painter = painterResource(R.drawable.community_removebg_preview),
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Create Tournament",
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

        // Tournament Creation Section
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields

            Spacer(modifier = Modifier.height(16.dp))

            // Tournament Name Input
            OutlinedTextField(
                value = tournamentViewModel.nameTournamentInput,
                onValueChange = { newValue ->
                    tournamentViewModel.nameTournamentInput = newValue
                },
                label = { Text("Tournament Name") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Description Input
            OutlinedTextField(
                value =  tournamentViewModel.descriptionInput,
                onValueChange = { newValue ->
                    tournamentViewModel.descriptionInput = newValue },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                maxLines = 3
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Cost Input
            OutlinedTextField(
                value = tournamentViewModel.costInput,
                onValueChange = { newValue ->
                    tournamentViewModel.costInput = newValue },
                label = { Text("Cost") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Tournament Type Input
            OutlinedTextField(
                value = tournamentViewModel.typeInput,
                onValueChange = { newValue ->
                    tournamentViewModel.typeInput = newValue},
                label = { Text("Tournament Type") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))


            Spacer(modifier = Modifier.height(18.dp))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                if (tournamentViewModel.imageInput != null) {
                    Image(
                        painter = rememberAsyncImagePainter(tournamentViewModel.imageInput),
                        contentDescription = "Tournament Image",
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text(
                        text = "Upload Image",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { launcher.launch("image/*") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8FACE7))
            ) {
                Text(
                    text = "Choose Image",
                    color = Color.White
                ) // Teks tombol dibuat putih agar terlihat jelas
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Create Tournament Button
            Button(
                onClick = { /* Create tournament logic */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF8FACE7))
            ) {
                Text(text = "Create Tournament", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

