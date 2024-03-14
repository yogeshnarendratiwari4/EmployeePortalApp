package com.example.app
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth


fun login(email : String,password : String){
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,
        password
    ).addOnCompleteListener{
        if(it.isSuccessful){
            Log.d("Sign in", "success")
        }
        else{
            Log.w("Sign in", "signInWithEmail:failure", it.exception)
//            Toast.makeText(android.content.,"Login failed : " + it.exception.toString(),Toast.LENGTH_LONG).show()
        }

    }
}
@Preview(showBackground = true)
@Composable
fun LoginPage () {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(Color.Black, Color.Red)
        )
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            AsyncImage(
                modifier = Modifier.padding(50.dp),
                model = "https://moneyview.in/img/logo-light.png",
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "money-view-logo",
            )
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                "Login to your account",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter your email address", color = Color.Gray) },
                singleLine = true,
                textStyle = TextStyle(brush = brush)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Enter your password", color = Color.Gray) },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    login(email, password)
                },
                modifier = Modifier.width(110.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        android.graphics.Color.parseColor("#6FB933")
                    )
                )
            ) {
                Text(text = "Login")
            }
        }
    }
}

