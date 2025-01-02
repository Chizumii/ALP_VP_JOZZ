package com.example.alp_vp_jozz.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Signin(onCreateAccountClick: () -> Unit) {
    SharedLayout {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome",
                fontSize = 28.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email Field
            val emailState = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password Field
            val passwordState = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Sign In Button
            Button(
                onClick = { /* Handle Sign In */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF5A5AFF))
            ) {
                Text(text = "Sign In", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Create Account Text
            Text(
                text = "or Create Account",
                color = Color.Cyan,
                modifier = Modifier.clickable { onCreateAccountClick() },
                fontSize = 16.sp
            )
        }
    }
}
@Preview(showBackground = true, name = "Sign In Preview")
@Composable
fun SignInPagePreview() {
    Signin(onCreateAccountClick = {})
}
