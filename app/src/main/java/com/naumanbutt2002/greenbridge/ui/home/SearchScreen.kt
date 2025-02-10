package com.naumanbutt2002.greenbridge.ui.home



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import com.naumanbutt2002.greenbridge.ui.home.components.SearchBar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.syllabus.TabItem
import com.naumanbutt2002.greenbridge.ui.syllabus.TopTabRow
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {

        // Top Row: Back Button
        TopRow(
            title = "",
            onBackClick = { /* Handle back button click */ },
        )

        SearchBar(
            textState = "",  // Pass the textState as String
            onValueChange = { },  // Update searchText when value changes
            placeholderText = "Geometric |",  // Custom placeholder text
            placeholderColor = Color.Black,  // Custom placeholder color
            showSearchIcon = false  // Show search icon
        )
        Spacer(modifier = Modifier.height(8.dp))
        val detail_events = listOf(
            SearchContentEvent(
                imageResId = R.drawable.math,
                title = "A triangle has two angles measuring 50° and 60°. What is the measure of the third angle?",
                buttonText = "JAMB UTME - 1997",
                buttonTextColor=Color(0xFF3D8543),
                buttonBgColor=Color(0xFFEFFCF0),
            ),
            SearchContentEvent(
                imageResId = R.drawable.math,
                title = "A circle has a radius of 7 cm. Find the circumference and area of the circle. (Use π ≈ 3.14)",
                buttonText = "WAEC - 2007",
                buttonTextColor=Color(0xFFEE3E09),
                buttonBgColor=Color(0xFFFCF2EF),
            ),
            SearchContentEvent(
                imageResId = R.drawable.math,
                title = "A circle has a radius of 7 cm. Find the circumference and area of the circle. (Use π ≈ 3.14)",
                buttonText = "WAEC - 1999",
                buttonTextColor=Color(0xFFEE3E09),
                buttonBgColor=Color(0xFFFCF2EF),
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp, horizontal = 20.dp),
        ) {
            items(detail_events) { event ->
                SearchContentCardWithImage(event)
            }
        }

    }
}
@Composable
fun SearchContentCardWithImage(event: SearchContentEvent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .height(250.dp)
            .padding(bottom = 8.dp)
            .border(1.dp, Color(0xFFF0F0F0), RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
//        elevation = CardDefaults.cardElevation(1.dp)
    )
    {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 14.dp)
        ) {
            // Image Section
            Image(
                painter = painterResource(id = event.imageResId),
                contentDescription = "Event Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(143.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                contentAlignment = Alignment.Center, // Ensures text is centered
                modifier = Modifier
                    .background(
                        color = event.buttonBgColor, // Selected: Green, Unselected: Gray
                        shape = CircleShape // Rounded corners
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp) // Padding for internal content
            ) {
                Text(
                    text = event.buttonText,
                    color = event.buttonTextColor, // Selected: White, Unselected: Dark Gray
                    fontWeight = FontWeight(500),
                    fontSize = 7.sp,
                    fontFamily = PoppinsFontFamily,
                    lineHeight = 15.sp,
                )
            }
            Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = event.title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = Color.Black,
                    fontFamily = PoppinsFontFamily,
                )


            }

    }
}

// Data model for the card
data class SearchContentEvent(
    val imageResId: Int,
    val title: String,
    val buttonText: String,
    val buttonTextColor: Color,
    val buttonBgColor: Color,
)
@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    GreenBridgeTheme {
        SearchScreen()
    }
}
