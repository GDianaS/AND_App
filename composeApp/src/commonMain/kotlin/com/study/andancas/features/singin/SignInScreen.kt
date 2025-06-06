package com.study.andancas.features.singin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.andancas.ui.ActionButton
import com.study.andancas.ui.BottomBar
import com.study.andancas.ui.Header
import com.study.andancas.ui.OutlinedInputField

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    navigateToLoginScreen: () -> Unit

    ) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var confirmPasswordError by remember { mutableStateOf("") }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
        )
    {

        Column(
            modifier = modifier
                .fillMaxSize()
                .systemBarsPadding()
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,


        ) {

            Spacer(Modifier.height(64.dp))

            Text(
                text = "Cadastro",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                fontWeight = FontWeight.Black)

            Spacer(Modifier.height(32.dp))

            Text(text = "Preencha com os seus dados")

            Spacer(Modifier.height(8.dp))

            TextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(
                        if (nameError.isEmpty()) "Name" else nameError,
                        color = if (nameError.isNotEmpty()) Color.Red else Color.Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Rounded.Person, contentDescription = null)
                },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(62.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(Modifier.height(8.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        if (emailError.isEmpty()) "Email" else emailError,
                        color = if (emailError.isNotEmpty()) Color.Red else Color.Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Rounded.AccountCircle, contentDescription = null)
                },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(62.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        if (passwordError.isEmpty()) "Senha" else passwordError,
                        color = if (passwordError.isNotEmpty()) Color.Red else Color.Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Rounded.Lock, contentDescription = null)
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (passwordVisible) "Esconder senha" else "Mostrar senha"

                    Icon(
                        image,
                        contentDescription = description,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp)
                            .clickable { passwordVisible = !passwordVisible }
                    )
                },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(62.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(Modifier.height(16.dp))

            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = {
                    Text(
                        if (confirmPasswordError.isEmpty()) "Confirmar senha" else confirmPasswordError,
                        color = if (confirmPasswordError.isNotEmpty()) Color.Red else Color.Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Rounded.Lock, contentDescription = null)
                },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (confirmPasswordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (confirmPasswordVisible) "Esconder senha" else "Mostrar senha"

                    Icon(
                        image,
                        contentDescription = description,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp)
                            .clickable { confirmPasswordVisible = !confirmPasswordVisible }
                    )
                },
                shape = RoundedCornerShape(30.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(62.dp)
                    .padding(horizontal = 16.dp)
            )


            Spacer(Modifier.height(16.dp))

            TermsCondictions(
                onCheckedChanged = {/*TODO*/})

            Spacer(Modifier.height(32.dp))

            ActionButton(
                modifier=Modifier.padding(start = 16.dp, end = 16.dp),
                text = "Concluir",
                isNavigationArrowVisible = true,
                onClicked = {
                    nameError = if (name.isBlank()) "Preencher Nome" else ""
                    emailError = if(email.isBlank()) "Preencher Email" else ""
                    passwordError = if (password.isBlank()) "Preencher Senha" else ""
                    confirmPasswordError = if (confirmPassword.isBlank()) "Preencher Confirmar Senha"
                        else (if (password != confirmPassword) "Senha e Confirmar Senha são Diferentes" else "")

                            if(nameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty() && confirmPasswordError.isEmpty()){
                                //TODO
                            }

                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black
                )

            )

            Spacer(Modifier.height(16.dp))

            TextButton(onClick = navigateToLoginScreen){
                Text(text = "Já tem uma conta? Entrar")
            }

        }
    }

}


@Composable
fun TermsCondictions(onCheckedChanged: (Boolean) -> Unit,
                     modifier: Modifier = Modifier) {
    var checkedState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState = it
                onCheckedChanged(it)
            },
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = Color.Black

            )
        )

        Text(
            text = "Concordo com os Termos & Condições",
            fontSize = 14.sp
        )
    }
}