package com.study.andancas.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    showMenuIcon: Boolean = false,
    onMenuClick: (() -> Unit)? = null,
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black
){
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = 12.dp),
        color = backgroundColor,
        shadowElevation = 12.dp,
        tonalElevation = 6.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Ícone da esquerda
            AnimatedHeaderIcon(
                visible = showBackButton,
                icon = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "Voltar",
                onClick = onBackClick,
                contentColor = contentColor
            )

            // Título da Tela
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = contentColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            // Ícone da direita
            AnimatedHeaderIcon(
                visible = showMenuIcon,
                icon = Icons.AutoMirrored.Filled.List,
                contentDescription = "Menu",
                onClick = onMenuClick,
                contentColor = contentColor
            )

        }
    }

}

@Composable
private fun AnimatedHeaderIcon(
    visible: Boolean,
    icon: ImageVector,
    contentDescription: String,
    onClick: (() -> Unit)?,
    contentColor: Color
) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        animationSpec = tween(durationMillis = 100),
        label = "iconScale"
    )

    val iconAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 200),
        label = "iconAlpha"
    )

    Box(
        modifier = Modifier
            .size(48.dp)
            .scale(scale)
            .clip(CircleShape)
            .background(
                if (visible) Color.Transparent else Color.Transparent
            )
            .clickable(
                enabled = visible && onClick != null,
                interactionSource = remember { MutableInteractionSource() },
                indication = androidx.compose.material3.ripple(
                    bounded = true,
                    radius = 24.dp,
                    color = contentColor
                ),
                onClick = { onClick?.invoke() }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (visible) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = contentColor.copy(alpha = iconAlpha),
                modifier = Modifier.size(26.dp)
            )
        }
    }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            kotlinx.coroutines.delay(100)
            isPressed = false
        }
    }
}


/*
@Composable
fun Header(
    modifier: Modifier = Modifier,
    title : String, // título
    showBackButton: Boolean = false, //botão de voltar
    onBackClick: (() -> Unit)? = null,
    showMenuIcon: Boolean = false, // icone a direita
    onMenuClick: (() -> Unit)? = null
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        // Ícone da esquerda
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.White)
                .shadow(
                    elevation = 2.dp,
                    shape = CircleShape,
                    ambientColor = Color.LightGray, // Cores sutis para a sombra
                    spotColor = Color.LightGray
                )
                .clickable {
                    onBackClick?.invoke()
                },
            contentAlignment = Alignment.Center
        ){
            when{
                showBackButton -> {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.Black
                    )
                }
            }

        }

        // Título da Tela

        Text(
            text = title,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        // Ícone da direita

        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.White)
                .shadow(
                    elevation = 2.dp,
                    shape = CircleShape,
                    ambientColor = Color.LightGray, // Cores sutis para a sombra
                    spotColor = Color.LightGray
                )
                .clickable {onMenuClick?.invoke()},
            contentAlignment = Alignment.Center
        ){
            when{
                showMenuIcon -> {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.List,
                        contentDescription = "Menu",
                        tint = Color.Black
                    )
                }
            }
        }

    }
}
*/