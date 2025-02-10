package com.naumanbutt2002.greenbridge.ui.timetable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimetableDetail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Timetable",
            onBackClick = { /* Handle back button click */ },
        )

        // Calendar Section
        CustomCalendarScreen()


        // Upcoming Events Section
        UpcomingEventsSection()
        }
    }
@Composable
fun CustomCalendarScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        // Calendar Header
        CalendarHeaderSection(
            monthTitle = "May, 2024",
            onPreviousClick = { /* TODO: Handle previous month */ },
            onNextClick = { /* TODO: Handle next month */ }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Calendar Grid Section
        CalendarGridSection()
    }
}

@Composable
fun CalendarHeaderSection(
    monthTitle: String,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF2F2F2), // Light gray background
                shape = RoundedCornerShape(50.dp) // Rounded corners
            )
            .padding(vertical = 9.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left Arrow Icon with Circle
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = onPreviousClick) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Previous",
                    tint = Color(0xFF323232),
                    modifier = Modifier.size(20.dp),


                )
            }
        }

        // Center Title with Calendar Icon
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.calendar_black),
                contentDescription = "Calendar",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = monthTitle,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontFamily = PoppinsFontFamily
                )
            )
        }

        // Right Arrow Icon with Circle
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = onNextClick) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = Color(0xFF323232),
                    modifier = Modifier.size(20.dp)

                )
            }
        }
    }
}

@Composable
fun CalendarGridSection() {
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val previousMonthDates = listOf(25, 26, 27, 28, 29, 30) // Previous month's dates
    val currentMonthDates = (1..31).toList() // Current month's dates
    val highlightedDates = listOf(17, 18, 19) // Green highlighted dates
    val blackCircleDates = listOf(4, 21, 24) // Dates with black background
    val lightGreenRowRange = 17..19 // Dates range for light green background

    val daysBeforeStart = 6 // May starts on Saturday
    val totalCells = 42 // Total grid cells (6 rows x 7 days)
    val cells = List(totalCells) { index ->
        when {
            index < daysBeforeStart -> previousMonthDates[index]
            else -> {
                val currentIndex = index - daysBeforeStart
                if (currentIndex < currentMonthDates.size) currentMonthDates[currentIndex] else null
            }
        }
    }

    // Days of the Week Header
    Row(modifier = Modifier.fillMaxWidth()) {
        for (day in daysOfWeek) {
            Text(
                text = day,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.5.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xFF474748)
            )
        }
    }

    Spacer(modifier = Modifier.height(12.dp))

    // Calendar Grid
    Column {
        for (week in cells.chunked(7)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp) // Fixed row height
            ) {
                // Light Green Background Layer for Specific Cells (17 to 19)
                Row(
                    modifier = Modifier
                        .offset(x = 40.dp, y = 3.dp) // Align with calendar row
                        .fillMaxHeight()
                        .width(240.dp) // Fixed width
                ) {
                    week.forEachIndexed { index, date ->
                        val isLightGreenCell = date in lightGreenRowRange
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .background(
                                    color = if (isLightGreenCell) Color(0xFFDBF0DD) else Color.Transparent,
                                    shape = RoundedCornerShape(0.dp)
                                )
                        ) {}
                    }
                }

                // Foreground Layer for Dates
                Row {
                    week.forEach { date ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(8.dp)
                                .background(
                                    color = when {
                                        date in blackCircleDates -> Color(0xFF3E3E3E) // Black circle dates
                                        date in highlightedDates -> Color(0xFF3D8543) // Green circle dates
                                        date != null -> Color(0xFFF2F2F2) // Gray background for dates
                                        else -> Color.Transparent
                                    },
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (date != null) {
                                Text(
                                    text = "$date",
                                    fontSize = 10.sp,
                                    fontFamily = PoppinsFontFamily,
                                    fontWeight = when {
                                        date in previousMonthDates -> FontWeight.Normal
                                        else -> FontWeight.Medium
                                    },
                                    color = when {
                                        date in blackCircleDates || date in highlightedDates -> Color.White
                                        date in previousMonthDates -> Color(0xFF3E3E3E)
                                        else -> Color.Black
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}





@Composable
fun UpcomingEventsSection() {
    val events = listOf(
        Event("NECO", "Mathematics", "20th July, 2024", Color(0xFFECFFF4),Color(0xFFDBF4E6),Color(0xFFDCEBE2),R.drawable.calendar_green),
        Event("WAEC", "History", "30th November, 2024", Color(0xFFEDECFF),Color(0xFFE6E4FF),Color(0xFFE8E7FF),R.drawable.calendar_purple),
        Event("JAMB", "English", "3 October, 2024", Color(0xFFECF4FF),Color(0xFFD2E1F5),Color(0xFFDCE7F6),R.drawable.calendar_dark_purple),
        Event("WAEC", "Religious", "30th November, 2024", Color(0xFFFFF5EC),Color(0xFFF9E9DC),Color(0xFFF1EEEB),R.drawable.calendar_dark_t_pink),
    )

    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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

        Spacer(modifier = Modifier.height(10.dp))

        // Events grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(400.dp)
        ) {
            items(events) { event ->
                EventCard(event)
            }
        }
    }
}

@Composable
fun EventCard(event: Event) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .background(event.primaryColor, shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .border(2.dp, event.borderColor, shape = RoundedCornerShape(12.dp))
            .height(167.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 20.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .background(event.secondaryColor, shape = RoundedCornerShape(6.dp))
                    .size(38.25.dp)
            )
            {
                Image(
                    painter = painterResource(id = event.imageRes),
                    contentDescription = "${event.name} Image",
                    modifier = Modifier
                        .size(20.dp)
                        .align(
                            Alignment.Center
                        )                )
//
                }
            Text(
                text = event.name,
                fontWeight = FontWeight.Medium,
                fontFamily = PoppinsFontFamily,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = event.subject,
                fontFamily = PoppinsFontFamily,
                fontSize = 12.75.sp,
                color = Color(0xFFBCBABA)
            )

            Text(
                text = event.date,
                fontFamily = PoppinsFontFamily,
                fontSize = 12.75.sp,
                color = Color(0xFF807E7E),
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}

data class Event(val name: String, val subject: String, val date: String, val primaryColor: Color, val secondaryColor: Color,val borderColor: Color, val imageRes: Int)
@Preview(showBackground = true)
@Composable
fun PreviewTimetableDetail() {
    GreenBridgeTheme {
        TimetableDetail()
    }
}
