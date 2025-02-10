package com.naumanbutt2002.greenbridge.ui.accountsetup.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color, // Default green background
    contentColor: Color, // Default white text color
    elevation: Dp = 10.dp, // Default shadow elevation
    shape: RoundedCornerShape = RoundedCornerShape(24.dp), // Default rounded corners
    buttonWidth: Dp = Dp.Unspecified, // Default button width, will use full width if unspecified
    buttonHeight: Dp = 48.dp, // Default button height
    textFontSize: Int = 14 // Default text font size
) {
    Box(
        modifier = modifier
            .then(
                if (buttonWidth != Dp.Unspecified) Modifier.width(buttonWidth)
                else Modifier.fillMaxWidth()
            )
            .height(buttonHeight)
            .graphicsLayer {
                shadowElevation = elevation.toPx() // Shadow elevation
                this.shape = shape // Shape of the button
                clip = false // Ensures shadow is not clipped
                translationY = 10.dp.toPx() // Shadow offset
                renderEffect = null
            }
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .then(
                    if (buttonWidth != Dp.Unspecified) Modifier.width(buttonWidth)
                    else Modifier.fillMaxWidth()
                )
                .height(buttonHeight),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor, // Background color
                contentColor = contentColor // Text color
            ),
            shape = shape
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = textFontSize.sp, // Font size from parameter
                    fontFamily = PoppinsFontFamily, // Replace with your font family
                    fontWeight = FontWeight.Medium,
                    lineHeight = (textFontSize * 1.4).sp, // Dynamically calculate line height
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}
