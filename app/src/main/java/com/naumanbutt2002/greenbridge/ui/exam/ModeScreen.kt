package com.naumanbutt2002.greenbridge.ui.exam



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {

        // Top Row: Back Button
        TopRow(
            title = "English",
            onBackClick = { /* Handle back button click */ },
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA))
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 16.dp)
            )
            {
                Text(
                    text = "Mode of questions",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Select mode of questions",
                    color = Color(0xFFB5B5B5),
                    fontSize = 11.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 17.dp)
                    .background(Color(0xFFFAFAFA))
            ) {

                // Sections
                SectionItem(
                    title = "Practice mode",
                    section = "Practice questions and be good at it"
                )
                SectionItem(
                    title = "Exam mode",
                    section = "Practice questions and be good at it"
                )

            }
        }

    }
}
@Composable
fun SectionItem(title: String, section: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFFFFFF))
            .border(1.dp, Color(0xFFF8F8F8), RoundedCornerShape(8.dp))
            .padding(horizontal = 14.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically // Aligns items vertically
    ) {
        // Left Column with Section and Title
        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                color = Color.Black,
                fontSize = 12.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500)
            )
            Spacer(modifier = Modifier.height(3.dp)) // Small spacing between texts

            Text(
                text = section,
                color = Color(0xFFB5B5B5),
                fontSize = 10.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 16.sp,
                fontWeight = FontWeight(500)
            )
        }

        // Right Arrow Icon
        Icon(
            painter = painterResource(id = R.drawable.arrow_forward),
            modifier = Modifier
                .size(16.dp) // Adjust size of the arrow
                .padding(end = 8.dp), // Small padding to separate from text
            contentDescription = "Forward Icon",
            tint = Color(0xFF3E3E3E)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewModeScreen() {
    GreenBridgeTheme {
        ModeScreen()
    }
}
