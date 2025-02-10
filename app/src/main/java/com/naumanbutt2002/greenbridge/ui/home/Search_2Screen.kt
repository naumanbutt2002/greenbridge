package com.naumanbutt2002.greenbridge.ui.home




import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.home.components.SearchBar
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search_2Screen() {
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
            Search_2ContentEvent(
                imageResId = R.drawable.math,
                title = "A triangle has two angles measuring 50° and 60°. What is the measure of the third angle?",
                buttonText = "JAMB UTME - 1997",
                buttonTextColor=Color(0xFF3D8543),
                buttonBgColor=Color(0xFFEFFCF0),
                mcq_a="a",
                mcq_c="c",
                mcq_d="d",
                mcq_t1="18",
                mcq_t2="75",
                mcq_t3="75",
            ),

            Search_2ContentEvent(
                imageResId = R.drawable.math,
                title = "A circle has a radius of 7 cm. Find the circumference and area of the circle. (Use π ≈ 3.14)",
                buttonText = "WAEC - 2007",
                buttonTextColor=Color(0xFFEE3E09),
                buttonBgColor=Color(0xFFFCF2EF),
                mcq_a="a",
                mcq_c="c",
                mcq_d="d",
                mcq_t1="18",
                mcq_t2="75",
                mcq_t3="75",
            ),
//            Search_2ContentEvent(
//                imageResId = R.drawable.math,
//                title = "A circle has a radius of 7 cm. Find the circumference and area of the circle. (Use π ≈ 3.14)",
//                buttonText = "WAEC - 1999",
//                buttonTextColor=Color(0xFFEE3E09),
//                buttonBgColor=Color(0xFFFCF2EF),
//                mcq_a="a",
//                mcq_c="c",
//                mcq_d="d",
//                mcq_t1="18",
//                mcq_t2="75",
//                mcq_t3="75",
//            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp, horizontal = 20.dp),
        ) {
            items(detail_events) { event ->
                Search_2ContentCardWithImage(event)
            }
        }

    }
}
@Composable
fun Search_2ContentCardWithImage(event: Search_2ContentEvent) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
//                    .width(90.dp) // Consistent minimum width for tabs
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
                fontFamily = PoppinsFontFamily
            )
            Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .height(35.dp)
                        .fillMaxWidth()// Consistent minimum width for tabs
                        .background(
                            color = Color(0xFFF8F8F8),
                            shape = CircleShape // Rounded corners
                        )
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                )
                {
                    Box(contentAlignment = Alignment.Center, // Ensures text is centered
                        modifier = Modifier
                            .size(27.dp)
                            .background(
                                color = Color(0xFFE3E3E3),
                                shape = CircleShape // Rounded corners
                            )
                    )
                    {
                        Text(
                            text = event.mcq_a,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = Color.Black,
                            fontFamily = PoppinsFontFamily
                        )


                    }
                    Text(
                        text = event.mcq_t1,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = PoppinsFontFamily,
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .height(35.dp)
                        .border(1.dp, Color(0xFF3D8543), RoundedCornerShape(25.dp))
                        .fillMaxWidth()// Consistent minimum width for tabs
                        .background(
                            color = Color(0xFFEFF9F0),
                            shape = CircleShape // Rounded corners
                        )
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                )
                {
                    Box(contentAlignment = Alignment.Center, // Ensures text is centered
                        modifier = Modifier
                            .size(27.dp)
                            .background(
                                color = Color(0xFF3D8543), // Selected: Green, Unselected: Gray
                                shape = CircleShape // Rounded corners
                            )
                    )
                    {
                        Text(
                            text = "b",
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = Color.White,
                            fontFamily = PoppinsFontFamily
                        )


                    }
                    Text(
                        text = "75",
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = PoppinsFontFamily,
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier
                        .height(35.dp)
                        .fillMaxWidth()// Consistent minimum width for tabs
                        .background(
                            color = Color(0xFFF8F8F8),
                            shape = CircleShape // Rounded corners
                        )
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                )
                {
                    Box(contentAlignment = Alignment.Center, // Ensures text is centered
                        modifier = Modifier
                            .size(27.dp)
                            .background(
                                color = Color(0xFFE3E3E3),
                                shape = CircleShape // Rounded corners
                            )
                    )
                    {
                        Text(
                            text = event.mcq_c,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = Color.Black,
                            fontFamily = PoppinsFontFamily
                        )


                    }
                    Text(
                        text = event.mcq_t2,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = PoppinsFontFamily,
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                    modifier = Modifier
                        .height(35.dp)
                        .fillMaxWidth()// Consistent minimum width for tabs
                        .background(
                            color = Color(0xFFF8F8F8),
                            shape = CircleShape // Rounded corners
                        )
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                )
                {
                    Box(contentAlignment = Alignment.Center, // Ensures text is centered
                        modifier = Modifier
                            .size(27.dp)
                            .background(
                                color = Color(0xFFE3E3E3),
                                shape = CircleShape // Rounded corners
                            )
                    )
                    {
                        Text(
                            text = event.mcq_d,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = Color.Black,
                            fontFamily = PoppinsFontFamily
                        )


                    }
                    Text(
                        text = event.mcq_t3,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontFamily = PoppinsFontFamily,
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .align(Alignment.CenterVertically),
                    )
                }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                CustomButton(
                    text = "Close",
                    onClick = {},
                    buttonColor = Color(0xFFDAE9DB), // Green background
                    contentColor = Color(0xFF3D8543),// White text
                    buttonWidth = 146.dp, // Custom button width
                    buttonHeight = 28.dp, // Custom button height
                    textFontSize = 10,
                    elevation = 5.dp
                )

                Spacer(modifier=Modifier.weight(1f))
                CustomButton(
                    text = "Show Answer",
                    onClick = {},
                    buttonColor = Color(0xFF3D8543), // Green background
                    contentColor = Color.White,// White text
                    buttonWidth = 146.dp, // Custom button width
                    buttonHeight = 28.dp, // Custom button height
                    textFontSize = 10,
                    elevation = 5.dp
                )

            }
            Spacer(modifier=Modifier.height(15.dp))

        }

    }
}

// Data model for the card
data class Search_2ContentEvent(
    val imageResId: Int,
    val title: String,
    val buttonText: String,
    val buttonTextColor: Color,
    val buttonBgColor: Color,
    val mcq_a:String,
    val mcq_c:String,
    val mcq_d:String,
    val mcq_t1:String,
    val mcq_t2:String,
    val mcq_t3:String,
)
@Preview(showBackground = true)
@Composable
fun PreviewSearch_2Screen() {
    GreenBridgeTheme {
        Search_2Screen()
    }
}
