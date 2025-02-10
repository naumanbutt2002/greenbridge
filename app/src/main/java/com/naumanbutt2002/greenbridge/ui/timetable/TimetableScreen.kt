package com.naumanbutt2002.greenbridge.ui.timetable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import com.naumanbutt2002.greenbridge.ui.syllabus.TabItem
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimetableScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Timetable",
            onBackClick = { /* Handle back button click */ },
            rightContent = {
                Image(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "Settings Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { /* Handle image click */ }
                )
            }        )


        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA))
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .background(Color(0xFFFAFAFA))
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFF0E7FD))
                        .border(1.dp, Color(0xFFF8F8F8), RoundedCornerShape(8.dp))
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically // Aligns items vertically
                ) {
                    // Left Column with Section and Title
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Stay Updated on your upcoming exam",
                            color = Color(0xFF3E3E3E),
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 15.sp,
                            fontWeight = FontWeight(600)
                        )

                        Spacer(modifier = Modifier.height(4.dp)) // Small spacing between texts

                        Text(
                            text = "Know more about your exams and how to stay prepared",
                            color = Color(0xFF878787),
                            fontSize = 9.sp,
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 12.sp,
                            fontWeight = FontWeight(500)
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Small spacing between texts

                        Text(
                            text = "Learn More",
                            color = Color(0xFF340677),
                            fontSize = 11.sp,
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 12.sp,
                            fontWeight = FontWeight(600)
                        )
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.ic_upcoming_exam),
                        modifier = Modifier
                            .size(80.dp), // Adjust size
                        contentDescription = "Upcoming Exam",
                        tint = Color(0xFF3E3E3E)
                    )
                }
            }}

                TopTabRowT()

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .background(Color(0xFFFAFAFA))
            ) {

                // Sections
                SectionItem(title = "English Language")
                SectionItem(title = "Agricultural science")
                SectionItem(title = "Mathematics")
                SectionItem(title = "Food tech")
            }
        }}
}
@Composable
fun TopTabRowT() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItem("WAEC Timetable", isSelected = true)
        TabItem("JAMB Timetable", isSelected = false)
        TabItem("NECO Timetable", isSelected = false)
    }
}
@Composable
fun SectionItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFCFCFC))
            .border(1.dp, Color(0xFFF8F8F8), RoundedCornerShape(8.dp))
            .padding(horizontal = 15.dp, vertical = 20.dp),
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
fun PreviewTimetableScreen() {
    GreenBridgeTheme {
        TimetableScreen()
    }
}
