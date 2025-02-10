package com.naumanbutt2002.greenbridge.ui.exam





import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mode_4Screen() {
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

        StudyModeDialog()

    }
}
@Composable
fun StudyModeDialog() {
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
                    .height(331.dp) // 30% height of the screen
                    .offset(y = (0.25f * LocalConfiguration.current.screenHeightDp).dp) // Offset 25% from the top
                    .align(Alignment.TopCenter) // Center horizontally at the top
                    .clip(RoundedCornerShape(16.dp)) // Rounded corners
                    .background(Color.White) // White background for box
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp))
            ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 22.dp, vertical = 48.dp)
                    ) {
                        // Missing Diagram Box
                        Box(
                            modifier = Modifier
                                .width(276.dp)
                                .height(144.dp)
                                .clip(RoundedCornerShape(5.dp)) // Rounded corners
                                .background(Color.White) // White background
                                .border(1.dp, Color(0xFFF0F0F0), RoundedCornerShape(5.dp))
                                .zIndex(0f) // Set the back layer
                        ) {
                            Text(
                                text = "Missing Diagram",
                                fontFamily = PoppinsFontFamily,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 10.dp, top = 11.dp)
                            )
                        }

                        // Add Details Box (on top layer)
                        Box(
                            modifier = Modifier
                                .offset(
                                    x = 11.dp,
                                    y = (-7).dp
                                ) // Offset to position it over the border line
                                .width(80.dp)
                                .height(20.dp)
                                .background(Color.White) // White background for box
                                .zIndex(1f) // Set the front layer
                        ) {
                            Text(
                                text = "Add Details",
                                fontFamily = PoppinsFontFamily,
                                fontSize = 10.sp, // Slightly larger to be fully visible
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFFBEBDBD),
                                modifier = Modifier.offset(y=(-5).dp).padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }


                    Box(
                        modifier = Modifier.padding(top=226.dp,start=22.dp,end=22.dp),
                    )
                    {
                        CustomButton(
                            text = "Report",
                            onClick = {                        },
                            buttonColor = Color(0xFF3D8543), // Red background
                            contentColor = Color.White, // White text
                            buttonWidth = 283.dp,
                            buttonHeight = 48.dp,
                            textFontSize = 14,
                            elevation = 0.dp,
                            shape = RoundedCornerShape(6.dp)
                        )
                    }


            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMode_4Screen() {
    GreenBridgeTheme {
        Mode_4Screen()
    }
}
