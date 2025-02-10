package com.naumanbutt2002.greenbridge.ui.accountsetup.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@Composable
fun CustomTextField(
    text: String, // Text to display
    textColor:Color,
    lineColor:Color,
    onTextChange: (String) -> Unit // Callback to update text
) {
    // Text field container
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(33.dp),
        contentAlignment = Alignment.CenterStart // Align content to the top-left
    ) {
        BasicTextField(
            value = text,
            onValueChange = { onTextChange(it) }, // Update text dynamically
            singleLine = true,
            textStyle = TextStyle(
                color = textColor, // Text color
                fontSize = 16.sp ,// Font size
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight(500),


                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 0.dp, vertical = 0.dp) // Ensure no padding
                .drawBehind { // Draw custom underline
                    val underlineColor = lineColor
                    drawLine(
                        color = underlineColor,
                        start = androidx.compose.ui.geometry.Offset(0f, size.height),
                        end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                        strokeWidth = 1.dp.toPx()
                    )
                }
        )
    }
}
