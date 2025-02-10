import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
fun RecommendedBooks() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Basic Concept",
            onBackClick = { /* Handle back button click */ },
        )
        TopTabRowRecommendedBooks()

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Column (
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .padding(start=7.dp, bottom = 9.dp,top=8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.book_img_1),
                        modifier = Modifier
                            .height(119.dp)
                            .width(145.dp),
                        contentDescription ="",
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                    )
                    {

                        Text(
                            text = "Agricultural Extension in Practice",
                            color = MaterialTheme.colorScheme.scrim, // Selected: White, Unselected: Dark Gray
                            fontWeight = FontWeight(500),
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.BookmarkBorder,
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Text(
                                text = "Oxford University Press",
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Selected: White, Unselected: Dark Gray
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.hashstraight),
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Text(
                                text = "978-0-19-92382-1",
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Selected: White, Unselected: Dark Gray
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Text(
                                text = "2015",
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Selected: White, Unselected: Dark Gray
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                    }
                }

            }

            Column (
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(start=7.dp, bottom = 9.dp,top=8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.book_img_2),
                        modifier = Modifier
                            .height(119.dp)
                            .width(145.dp),
                        contentDescription ="",
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                    )
                    {
                        Text(
                            text = "Agricultural Extension in Practice",
                            color = MaterialTheme.colorScheme.scrim, // Selected: White, Unselected: Dark Gray
                            fontWeight = FontWeight(500),
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.BookmarkBorder,
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Text(
                                text = "Oxford University Press",
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Selected: White, Unselected: Dark Gray
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.hashstraight),
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Text(
                                text = "978-0-19-92382-1",
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Selected: White, Unselected: Dark Gray
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Text(
                                text = "2015",
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Selected: White, Unselected: Dark Gray
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                    }
                }

            }


        }

    }
}
@Composable
fun TopTabRowRecommendedBooks() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemL("Overview", isSelected = false)
        TabItemL("Videos", isSelected = false)
        TabItemL("Lesson Plans", isSelected = false)
        TabItemL("Recommended Books", isSelected = true)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRecommendedBooks() {
    GreenBridgeTheme {
        RecommendedBooks()
    }
}
