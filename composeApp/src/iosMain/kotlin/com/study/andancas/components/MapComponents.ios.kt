package com.study.andancas.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitViewController
import com.study.andancas.mapViewController
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun MapComponent() {
    // Componente de Map do lado do iOS
    UIKitViewController(
        factory = mapViewController,
        modifier = Modifier.fillMaxSize(),
        properties = UIKitInteropProperties(
            isInteractive = true,
            isNativeAccessibilityEnabled = true
        )
    )
}