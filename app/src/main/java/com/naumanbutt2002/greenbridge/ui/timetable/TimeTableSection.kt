package com.naumanbutt2002.greenbridge.ui.timetable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@Composable
fun TimeTableSection() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA).copy(alpha = 0.1f)) // Full Screen Background
    ) {
        // Full Screen Timetable Screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(0.5.dp)

        ) {
            TimetableScreen() // This takes the entire screen as a background
        }

        // Centered White Box for English Timetable
        timetableDialog()


    }
}
@Composable
fun timetableDialog() {
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
                    .fillMaxWidth(0.9f) // 90% width of the screen
                    .fillMaxHeight(0.3f) // 30% height of the screen
                    .offset(y = (0.25f * LocalConfiguration.current.screenHeightDp).dp) // Offset 25% from the top
                    .align(Alignment.TopCenter) // Center horizontally at the top
                    .clip(RoundedCornerShape(16.dp)) // Rounded corners
                    .background(Color.White) // White background for box
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 40.dp),

                    verticalArrangement = Arrangement.Center,

                    ) {
                    // Title
                    Text(
                        text = "English Timetable",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    // Information Rows
                    InfoRow(label = "Paper Code:", value = "JAMB-UTME")
                    InfoRow(label = "Exam Date:", value = " Tuesday, 25 April 2023", iconId = R.drawable.calendar_green)
                    InfoRow(label = "Start Time:", value = "  9:00 A.M")
                    InfoRow(label = "End Time:", value = "    12:00 P.M")
                    InfoRow(label = "Duration:", value = "     3 hour(s) 32 Minutes")
                }
            }
        }
    }
}
@Composable
fun InfoRow(label: String, value: String, iconId: Int? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Label
        Text(
            text = label,
            fontFamily = PoppinsFontFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        // Value
        Text(
            text = value,
            fontFamily = PoppinsFontFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFA6A3A3),
            modifier = Modifier.padding(start = 8.dp)
        )

        // Optional Icon for Exam Date
        if (iconId != null) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(19.12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTimeTableSection() {
    GreenBridgeTheme {
        TimeTableSection()
    }
}
