package com.naumanbutt2002.greenbridge.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.home.components.SearchBar
import com.naumanbutt2002.greenbridge.ui.syllabus.components.BottomNavigationBar
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen() {
    var selectedItem by remember { mutableStateOf(0) } // Default selected item index
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = { newIndex -> selectedItem = newIndex }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFFF9F9F9),

                    ),
        )
        {
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Greeting Text
                Text(
                    text = "Hello Zlant",
                    fontSize = 16.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp,
                    color = Color(0xFF262525)

                )

                // Notification Icon with Badge
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            color = Color(0xFFF2F1F1),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    // Notification Icon
                    Icon(
                        painter = painterResource(id = R.drawable.notification_black),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )

                    // Notification Badge (Red Dot)
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(x = 4.dp, y = (-4).dp) // Adjust position dynamically
                    ) {
                        drawCircle(
                            color = Color(0xFFFC1A1A),
                            radius = 2.dp.toPx() // Convert badge size to pixels
                        )
                    }
                }


            }


            Spacer(modifier = Modifier.height(16.dp))


            SearchBar(
                textState = "",  // Pass the textState as String
                onValueChange = { },  // Update searchText when value changes
                placeholderText = "Search courses",  // Custom placeholder text
                placeholderColor = Color(0xFFA4A4A4),  // Custom placeholder color
                showSearchIcon = true  // Show search icon
            )
            Spacer(modifier = Modifier.height(16.dp))

            WeeklyScoreCard()

            val events = listOf(
                UpcomingEvent("NECO", "Syllabus reviewed", "20th July, 2024"),
                UpcomingEvent("WAEC", "Registration closes", "30th November, 2024"),
                UpcomingEvent("JAMB", "Timetable out", "3 October, 2024"),
                UpcomingEvent("WAEC", "Registration closes", "30th November, 2024")
            )

            UpcomingEventsSection(events = events)


            Spacer(modifier = Modifier.height(24.dp))

            // Top Searched Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Top searched",
                    fontSize = 13.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
                Text(
                    text = "See all",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF3D8543)
                )
            }
            val detail_events = listOf(
                DetailedEvent(
                    imageResId = R.drawable.physicalhealth,
                    title = "Physical Health Education",
                    subtitle = "JAMB 2024",
                    description = "Registration closes"
                ),
                DetailedEvent(
                    imageResId = R.drawable.agriculture,
                    title = "Agricultural Science",
                    subtitle = "WAEC 2024",
                    description = "Registration closes"
                )
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 20.dp),
            ) {
                items(detail_events) { event ->
                    EventCardWithImage(event)
                }
            }

        }
    }
}


@Composable
fun WeeklyScoreCard() {
    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 18.dp)
            .fillMaxWidth()
            .height(260.dp)
            .border(1.dp, Color(0xFFF3F3F3), RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 18.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column()
                {
// Header
                    Text(
                        text = "267",
                        fontWeight = FontWeight.Bold,
                        fontFamily = PoppinsFontFamily,
                        fontSize = 20.sp,
                        lineHeight = 30.sp
                    )
                    Text(
                        text = "Your weekly average score",
                        color = Color(0xFFA7A7A7),
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsFontFamily,
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    )
                }

                // Dropdown
                    Spacer(modifier = Modifier.weight(1f))
                // Dropdown
                Row(
                    modifier = Modifier
                        .border(1.dp, Color(0xFFF5F5F5), RoundedCornerShape(2.dp))
                        .clickable { /* TODO: Add dropdown logic */ }
                        .width(63.dp)
                        .height(23.dp)
                        .padding(horizontal = 8.68.dp,),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Weekly",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsFontFamily,
                        fontSize = 8.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp)) // Espaciador entre el texto y la flecha
                    Icon(
                        modifier = Modifier.size(15.dp),
                        imageVector = Icons.Default.KeyboardArrowDown, // Usa un ícono de flecha predeterminado
                        contentDescription = "Dropdown arrow",
                        tint = Color(0xFFB2B1B1) // Color gris para la flecha
                    )
                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally)
            // Bar Chart
            {
                WeeklyBarChart()
            }
        }
    }
}

@Composable
fun WeeklyBarChart() {

    Row(
        modifier = Modifier
            .width(110.dp)
            .border(1.dp, Color(0xFFF5F5F5), RoundedCornerShape(2.dp))

    )
    {
        Row(
            modifier = Modifier
                .padding(3.dp)
                .height(31.dp)

        )
        {
            Box(modifier = Modifier
                .padding(horizontal = 2.dp)
                .align(Alignment.CenterVertically))
            {
                Image(
                    painter = painterResource(id = R.drawable.smile),
                    contentDescription ="smile",
                )
            }
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)){
                Text(
                    text = "250 Points",
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontFamily = PoppinsFontFamily,
                    fontSize = 9.sp,
                    lineHeight = 13.5.sp
                )
                Text(
                    text = "Monday, April 22nd",
                    color = Color(0xFFBDB8B8),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsFontFamily,
                    fontSize = 7.sp,
                    lineHeight = 10.71.sp
                )
            }
        }
    }
    StackedBarChart()

}


//Mobile
@Composable
fun StackedBarChart() {
    val data = listOf(
        Pair(100f, 300f), // Monday
        Pair(150f, 250f), // Tuesday
        Pair(200f, 200f), // Wednesday
        Pair(250f, 150f), // Thursday
        Pair(180f, 220f), // Friday
        Pair(120f, 280f), // Saturday
        Pair(100f, 300f)  // Sunday
    )
    val labels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val maxHeight = 400f // Maximum height for scaling
    val yAxisLabels = listOf(400, 200, 100)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
    ) {
        // Y-axis Labels
        Column(
            modifier = Modifier
                .height(100.dp)
                .padding(end = 0.dp, top = 3.dp, bottom = 0.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            yAxisLabels.forEach {
                Text(
                    text = it.toString(),
                    style = TextStyle(fontSize = 9.sp),
                    color = Color.Black,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        }

        // Bar Chart
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                val barWidth = 25.dp.toPx()
                val spacing = 16.dp.toPx()
                val labelYOffset = 10.dp.toPx()

                data.forEachIndexed { index, pair ->
                    val xStart = index * (barWidth + spacing) + spacing
                    val greenHeight = (pair.first / maxHeight) * size.height
                    val whiteHeight = (pair.second / maxHeight) * size.height

                    // Draw the green section
                    drawRoundRect(
                        color = Color(0xFF3D8543), // Green
                        topLeft = androidx.compose.ui.geometry.Offset(xStart, size.height - greenHeight),
                        size = androidx.compose.ui.geometry.Size(barWidth, greenHeight),
                        cornerRadius = CornerRadius(3f, 3f)
                    )

                    // Draw the white section above green
                    drawRoundRect(
                        color = Color(0xFFF2F5F9), // White
                        topLeft = androidx.compose.ui.geometry.Offset(xStart, size.height - greenHeight - whiteHeight),
                        size = androidx.compose.ui.geometry.Size(barWidth, whiteHeight),
                        cornerRadius = CornerRadius(3f, 3f)
                    )

                    // Draw the label below each bar
                    drawContext.canvas.nativeCanvas.drawText(
                        labels[index],
                        xStart + barWidth / 2, // Center the text under the bar
                        size.height + labelYOffset,
                        android.graphics.Paint().apply {
                            textSize = 16f
                            color = android.graphics.Color.GRAY
                            textAlign = android.graphics.Paint.Align.CENTER
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun UpcomingEventsSection(
    events: List<UpcomingEvent>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Section title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Upcoming events",
                fontSize = 13.sp,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight(500),
                color = Color.Black
            )
            Text(
                text = "See all",
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF3D8543)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // LazyRow for the cards
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(start = 20.dp)
        ) {
            items(events) { event ->
                EventCard(event = event)
            }
        }
    }
}

@Composable
fun EventCard(event: UpcomingEvent) {
    Card(
        modifier = Modifier
            .size(105.dp)
            .border(1.dp, Color(0xFFF0F0F0), shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 13.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .background(Color(0xFFF6F6F6), shape = RoundedCornerShape(6.dp))
                    .size(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.calendar_black),
                    contentDescription = "Calendar Image",
                    modifier = Modifier
                        .size(12.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = event.name,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                fontFamily = PoppinsFontFamily
            )
            Text(
                text = event.details,
                fontSize = 8.sp,
                color = Color(0xFFBCBABA),
                fontFamily = PoppinsFontFamily
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = event.date,
                fontWeight = FontWeight.Medium,
                fontSize = 8.sp,
                color = Color(0xFF807E7E),
                fontFamily = PoppinsFontFamily
            )
        }
    }
}
@Composable
fun EventCardWithImage(event: DetailedEvent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .padding(bottom = 8.dp)
            .border(1.dp, Color(0xFFF0F0F0), RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
//        elevation = CardDefaults.cardElevation(1.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Image Section
            Image(
                painter = painterResource(id = event.imageResId),
                contentDescription = "Event Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(92.dp)
                    .height(79.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(6.dp))

            // Text Section
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = event.title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = PoppinsFontFamily
                )
                Text(
                    text = event.subtitle,
                    fontWeight = FontWeight.Medium,
                    fontSize = 9.sp,
                    color = Color(0xFF807E7E),
                    fontFamily = PoppinsFontFamily
                )
                Text(
                    text = event.description,
                    fontSize = 8.sp,
                    color = Color(0xFFBCBABA),
                    fontFamily = PoppinsFontFamily
                )
            }
        }
    }
}

// Data model for the card
data class DetailedEvent(
    val imageResId: Int,
    val title: String,
    val subtitle: String,
    val description: String
)


// Data model for an upcoming event
data class UpcomingEvent(
    val name: String,
    val details: String,
    val date: String
)


@Preview(showBackground = true)
@Composable
fun HomePageScreenPreview() {
    GreenBridgeTheme {
        HomePageScreen()
    }
}
