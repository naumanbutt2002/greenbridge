package com.naumanbutt2002.greenbridge.ui.syllabus

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SyllabusSection() {
        Column(
            modifier = Modifier
                .fillMaxSize()
//                .background(Color.LightGray.copy(alpha = 0.01f)) // Slightly darker semi-transparent background
        ) {

// Top Row: Back Button
            TopRow(
                title = "Agriculture Science",
                onBackClick = { /* Handle back button click */ },
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)

            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()

                        .padding(horizontal = 20.dp, vertical = 15.dp)
                        .background(MaterialTheme.colorScheme.onBackground)

                ){
                // Search Bar
                var searchText by remember { mutableStateOf(TextFieldValue("")) }

                SearchBar(searchText) { searchText = it }

                Spacer(modifier = Modifier.height(8.dp))

                // Sections
                SectionItem(title = "Basic concept of Agricultural Science", section = "Section 1")
                SectionItem(title = "Agricultural Ecology", section = "Section 2")
                SectionItem(title = "Agricultural Engineering/Mechanization", section = "Section 3")
                SectionItem(title = "Plants", section = "Section 4")
            }

        }}
    }
@Composable
fun SearchBar(
    textState: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(50)) // Fully rounded corners
            .background(MaterialTheme.colorScheme.tertiaryContainer) // Light gray background
            .padding(horizontal = 16.dp, vertical = 12.dp) // Add padding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search Icon
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.scrim,
                modifier = Modifier.size(16.dp) // Adjust icon size
            )

            // Placeholder and Input Text
            BasicTextField(
                value = textState,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = TextStyle(color = MaterialTheme.colorScheme.scrim, fontSize = 11.sp),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .fillMaxWidth()
            ) {
                // Placeholder when input is empty
                if (textState.text.isEmpty()) {
                    Text(
                        text = "Search topics, sub-topics",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight(500),
                        fontFamily = PoppinsFontFamily,
                        lineHeight = 16.5.sp,
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}
@Composable
fun SectionItem(title: String, section: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.inverseSurface)
//            .background(Color(0xFFFCFCFC))
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
            .padding(horizontal = 14.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically // Aligns items vertically
    ) {
        // Left Column with Section and Title
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = section,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 11.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 17.sp,
                fontWeight = FontWeight(500)
            )

            Spacer(modifier = Modifier.height(4.dp)) // Small spacing between texts

            Text(
                text = title,
                color = MaterialTheme.colorScheme.scrim,
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
            tint = MaterialTheme.colorScheme.scrim
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSyllabusSection() {
    GreenBridgeTheme {
        SyllabusSection()
    }
}
