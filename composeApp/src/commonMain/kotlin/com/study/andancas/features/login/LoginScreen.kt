package com.study.andancas.features.login

import andancasappproject.composeapp.generated.resources.Res
import andancasappproject.composeapp.generated.resources.highfive
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.andancas.ui.ActionButton
import com.study.andancas.ui.InputField
import com.study.andancas.ui.OutlinedInputField
import io.ktor.http.ContentType
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToHomeScreen: () -> Unit,
    navigateToSigninScreen: () -> Unit
){

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
        Image(
            painter = painterResource(Res.drawable.highfive),
            contentDescription = null,
            modifier = Modifier.size(180.dp).padding(top = 32.dp)
        )

        Spacer(Modifier.height(16.dp))

        Message(
            title = "Bem-vindo de volta!",
            subtitle = "Login"
        )

        Spacer(Modifier.height(16.dp))

        OutlinedInputField(
            placeholdertext = "E-mail",
            leadingIcon = {
                Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )},
            modifier = Modifier.padding(16.dp))

        OutlinedInputField(
            placeholdertext = "Senha",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(16.dp))


        Spacer(Modifier.height(8.dp))

        RememberMeCheckbox(onCheckedChanged = {/*TODO*/})

        Spacer(Modifier.height(16.dp))

        ActionButton(
            modifier=Modifier.padding(start = 16.dp, end = 16.dp),
            text = "Entrar",
            isNavigationArrowVisible = true,
            onClicked = navigateToHomeScreen,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            )

        )

        Spacer(Modifier.height(16.dp))

        Separator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(24.dp)
        )

        Spacer(Modifier.height(16.dp))

        ActionButton(
            modifier=Modifier.padding(start = 16.dp, end = 16.dp),
            text = "Inscreva-se",
            isNavigationArrowVisible = true,
            onClicked = navigateToSigninScreen,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Gray
            )

        )

    }

}

@Composable
private fun Message(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String
){
  Column(
      modifier = modifier,
      verticalArrangement = Arrangement.spacedBy(4.dp)

  ) {
      Text(
          text = title,
          modifier = Modifier.fillMaxWidth(),
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.bodyLarge,
          color = Color.Black,
          fontWeight = FontWeight.Medium
      )
      Text(
          text = subtitle,
          modifier = Modifier.fillMaxWidth(),
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.headlineMedium,
          color = Color.Black,
          fontWeight = FontWeight.Black
      )
  }
}

@Composable
private fun Separator(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        DashedLine(
            modifier = Modifier.weight(weight = 1f)
        )

        Text(
            text = "Ou",
            style = MaterialTheme.typography.labelMedium,
            color = Color.DarkGray,
            fontSize = 14.sp)

        DashedLine(
            modifier = Modifier.weight(weight = 1f)
        )

    }
}

@Composable
private fun DashedLine(
    modifier: Modifier = Modifier
) {

    Canvas(modifier = modifier){
        drawLine(
            color = Color.DarkGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f),0f),
            cap = StrokeCap.Round,
            strokeWidth = 1.dp.toPx()
        )
    }

}

@Composable
fun RememberMeCheckbox(onCheckedChanged: (Boolean) -> Unit) {
    var checkedState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState = it
                onCheckedChanged(it) // Notifica a mudança de estado
            },
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = Color.Black

            )
        )

        Text(text = "Lembre-se de mim")
    }
}