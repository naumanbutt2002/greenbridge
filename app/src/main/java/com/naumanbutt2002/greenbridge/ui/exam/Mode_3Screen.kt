package com.naumanbutt2002.greenbridge.ui.exam





import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mode_3Screen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA).copy(alpha = 0.4f)) // Full Screen Background
    ) {
        // Full Screen Timetable Screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(0.5.dp)

        ) {
            Mode_2Screen() // This takes the entire screen as a background
        }

        Mode_3Dialog()

    }
}

@Composable
fun Mode_3Dialog() {
    // State to control dialog visibility
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000)) // Semi-transparent overlay
        ) {
            // Centered White Box for the dialog
            Box(
                modifier = Modifier
                    .width(327.dp) // 90% width of the screen
                    .height(196.dp) // 30% height of the screen
                    .offset(y = (0.25f * LocalConfiguration.current.screenHeightDp).dp) // Offset 25% from the top
                    .align(Alignment.TopCenter) // Center horizontally at the top
                    .clip(RoundedCornerShape(16.dp)) // Rounded corners
                    .background(Color.White) // White background for box
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                ) {
                    // Title
                    Text(
                        text = "End study mode",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    // Description
                    Text(
                        text = "Are you sure you want to quit the study session?",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF7E7E7E),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    // Row with two buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CustomButton(
                            text = "End session",
                            onClick = {
                                // Add your logic to end the session here
                                showDialog = false // Close dialog
                            },
                            buttonColor = Color(0xFFF30404), // Red background
                            contentColor = Color.White, // White text
                            buttonWidth = 131.dp,
                            buttonHeight = 34.dp,
                            textFontSize = 13,
                            elevation = 0.dp,
                            shape = RoundedCornerShape(6.dp)
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        CustomButton(
                            text = "Continue",
                            onClick = {
                                // Add your logic to continue the session here
                                showDialog = false // Close dialog
                            },
                            buttonColor = Color(0xFFF8F8F8), // Gray background
                            contentColor = Color.Black, // Black text
                            buttonWidth = 131.dp,
                            buttonHeight = 34.dp,
                            textFontSize = 13,
                            elevation = 0.dp,
                            shape = RoundedCornerShape(6.dp)
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMode_3Screen() {
    GreenBridgeTheme {
        Mode_3Screen()
    }
}
