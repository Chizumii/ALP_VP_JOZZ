// ui/ProfileScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.alp_vp_jozz.R
import com.example.alp_vp_jozz.viewModels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    userViewModel: UserViewModel,
    userId: String,
    authToken: String, // Token yang diperoleh setelah login
    onLogout: () -> Unit
) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var nomorTelp by remember { mutableStateOf("") }
    var nicknameGame by remember { mutableStateOf("") }

    val updateState by userViewModel.updateState.collectAsState()
    val logoutState by userViewModel.logoutState.collectAsState()



    Scaffold(
        topBar = { TopAppBar(title = { Text("Profile") }) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = namaDepan,
                    onValueChange = { namaDepan = it },
                    label = { Text("Nama Depan") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = namaBelakang,
                    onValueChange = { namaBelakang = it },
                    label = { Text("Nama Belakang") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nomorTelp,
                    onValueChange = { nomorTelp = it },
                    label = { Text("Nomor Telepon") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nicknameGame,
                    onValueChange = { nicknameGame = it },
                    label = { Text("Nickname Game") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        val request = UpdateUserRequest(
                            nama_depan = namaDepan,
                            nama_belakang = namaBelakang,
                            nomor_telp = nomorTelp,
                            nicknamegame = nicknameGame
                        )
                        userViewModel.updateUser(userId, request, authToken)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Update Profile")
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        userViewModel.logoutUser(authToken)
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        "Logout",
                        color = Color.White
                    ) // Pastikan teks kontras dengan latar belakang
                }

            }
        }
    )
    Column(
        modifier = Modifier
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
