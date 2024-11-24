package com.example.paperclip.ui.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import java.math.BigInteger


fun Double.roundToTwoDecimals(): Double {
    return kotlin.math.round(this * 100) / 100.00
}


@Composable
fun <T : Number> animateNumberAsState(
    targetValue: T,
    animationDuration: Int = 500
): T {
    return when (targetValue) {
        is Int -> {
            val animatedValue by animateIntAsState(
                targetValue = targetValue,
                animationSpec = tween(durationMillis = animationDuration)
            )
            animatedValue as T
        }

        is Double -> {
            // Limiter à 2 chiffres après la virgule DURANT l'animation
            val animatedValue by animateFloatAsState(
                targetValue = targetValue.toFloat(),
                animationSpec = tween(durationMillis = animationDuration)
            )
            // Arrondi immédiat pendant l'animation
            animatedValue.toDouble() as T
        }

        is BigInteger -> {
            val animatedValue by animateFloatAsState(
                targetValue = targetValue.toFloat(),
                animationSpec = tween(durationMillis = animationDuration)
            )
            BigInteger.valueOf(animatedValue.toLong()) as T
        }

        else -> throw IllegalArgumentException("Unsupported type for animation")
    }
}
