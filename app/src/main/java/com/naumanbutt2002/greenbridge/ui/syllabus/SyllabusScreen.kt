package com.naumanbutt2002.greenbridge.ui.syllabus


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.syllabus.components.BottomNavigationBar
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyllabusScreen() {
    var selectedItem by remember { mutableStateOf(3) } // Default selected item index
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedItem, // Pass the current selected item
                onItemSelected = { newIndex -> selectedItem = newIndex } // Update selected item
            )
        } // Call the BottomNavigationBar here

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 20.dp)
        ) {
            // Top tabs
            TopTabRow()

            // Subjects grid
            SubjectsGrid()
        }
    }
}
@Composable
fun TopTabRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
//        verticalAlignment = Alignment.CenterVertically
    ) {
        TabItem("WAEC Syllabus", isSelected = true)
        TabItem("JAMB Syllabus", isSelected = false)
        TabItem("NECO Syllabus", isSelected = false)
    }
}

@Composable
fun TabItem(title: String, isSelected: Boolean) {
    Box(
        contentAlignment = Alignment.Center, // Ensures text is centered
        modifier = Modifier
            .height(35.dp) // Fixed height for all tabs
            .defaultMinSize(minWidth = 120.dp) // Consistent minimum width for tabs
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiaryContainer, // Selected: Green, Unselected: Gray
                shape = CircleShape // Rounded corners
            )
            .padding(horizontal = 16.dp, vertical = 8.dp) // Padding for internal content
    ) {
        Text(
            text = title,
            color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.scrim, // Selected: White, Unselected: Dark Gray
            fontWeight = FontWeight(500),
            fontSize = 10.sp,
            fontFamily = PoppinsFontFamily,
            lineHeight = 15.sp,
            maxLines = 1 // Prevents text wrapping
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SubjectsGrid() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        val subjects = listOf(
            "English", "Maths", "Physics", "Chemistry",
            "Commerce", "Accounting", "PHE", "Geography",
            "Pure Arts", "Fu Math", "Health", "Civic"
        )

        subjects.forEach { subject ->
            SubjectCard(subject)
        }
    }
}

@Composable
fun SubjectCard(subject: String) {
    Card(
        modifier = Modifier
            .width(85.dp)
            .height(85.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = subject,
                fontWeight = FontWeight.Medium,
                fontFamily = PoppinsFontFamily,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.scrim,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "129 Questions",
                fontSize = 7.sp,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium,
                fontFamily = PoppinsFontFamily,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SyllabusScreenPreview() {
    GreenBridgeTheme {
        SyllabusScreen()
    }
}
