package com.study.andancas.features.singin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
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

    ) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),

        topBar = {
            Header(
                title = "Cadastro",
                showBackButton = true,
                showMenuIcon = true,
                onBackClick = onBackPressed
            )
        },

    )
    {

        Column(
            modifier = modifier
                .fillMaxSize()
                /*
                .background(
                    Brush.verticalGradient(
                        0f to Color.LightGray,
                        1f to Color.Black
                    )
                )*/
                .systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            /*
            Image(
                painter = painterResource(Res.drawable.register),
                contentDescription = null,
                modifier = Modifier.size(180.dp).padding(top = 32.dp)
            )*/

            Spacer(Modifier.height(64.dp))

            Text(
                text = "Cadastro",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                fontWeight = FontWeight.Black)

            Spacer(Modifier.height(64.dp))

            OutlinedInputField(
                placeholdertext = "Nome",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                },
                modifier = Modifier.padding(16.dp))

            OutlinedInputField(
                placeholdertext = "E-mail",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                },
                modifier = Modifier.padding(16.dp))

            OutlinedInputField(
                placeholdertext = "Senha",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(16.dp))

            OutlinedInputField(
                placeholdertext = "Confirmar Senha",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(16.dp))


            Spacer(Modifier.height(16.dp))

            TermsCondictions(
                onCheckedChanged = {/*TODO*/})

            Spacer(Modifier.height(32.dp))

            ActionButton(
                modifier=Modifier.padding(start = 16.dp, end = 16.dp),
                text = "Concluir",
                isNavigationArrowVisible = true,
                onClicked = {/*TODO*/},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black
                )

            )

            Spacer(Modifier.height(16.dp))
            Text(text = "Já tem uma conta? Entrar")

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