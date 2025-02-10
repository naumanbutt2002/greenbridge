package com.naumanbutt2002.greenbridge.ui.accountsetup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SegmentedProgressBar(
    currentStep: Int, // Current completed step (0-based index)
    totalSteps: Int, // Total number of steps
    activeColor: Color, // Solid green color
    inactiveColor: Color, // Solid gray color
    spacing: Dp // Spacing between segments
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween // Space evenly
    ) {
        for (step in 0 until totalSteps) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(3.dp)
                    .clip(RoundedCornerShape(50)) // Round corners
                    .background( // Gradient brush for active steps
                        if (step <= currentStep) {
                            Brush.horizontalGradient(
                                colors = listOf(
                                    activeColor,
                                    activeColor.copy(alpha = 0.8f)
                                )
                            )
                        } else {
                            Brush.horizontalGradient(
                                colors = listOf(
                                    inactiveColor,
                                    inactiveColor
                                )
                            )
                        }
                    )
            )
            // Add spacing between segments except the last one
            if (step < totalSteps - 1) {
                Spacer(modifier = Modifier.width(spacing))
            }
        }
    }
}
