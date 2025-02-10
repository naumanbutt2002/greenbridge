



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.syllabus.TabItem
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.TopTabRowT
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewScreen() {
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
        TopTabRowL()

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {

            Column (
                modifier = Modifier
                    .height(556.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=11.dp,end=11.dp,top=22.dp)
                )
                {

                    Row(
                        horizontalArrangement = Arrangement.Absolute.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(
                            text = "Overview",
                            color = MaterialTheme.colorScheme.scrim,
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                            fontFamily = PoppinsFontFamily,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, end = 6.dp)
                    )
                    {
                        Text(
                            text = "1. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            fontFamily = PoppinsFontFamily,
                            textAlign = TextAlign.Center,
                            lineHeight = 22.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text="2. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            fontFamily = PoppinsFontFamily,
                            textAlign = TextAlign.Center,
                            lineHeight = 22.sp

                        )
                    }

                }

            }

        }

    }
}
@Composable
fun TopTabRowL() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemL("Overview", isSelected = true)
        TabItemL("Videos", isSelected = false)
        TabItemL("Lesson Plans", isSelected = false)
        TabItemL("Recommended Books", isSelected = false)
    }
}
@Composable
fun TabItemL(title: String, isSelected: Boolean) {
    Box(
        contentAlignment = Alignment.Center, // Ensures text is centered
        modifier = Modifier
            .height(30.dp) // Fixed height for all tabs
            .defaultMinSize(minWidth = 73.82.dp) // Consistent minimum width for tabs
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.scrim else MaterialTheme.colorScheme.tertiaryContainer, // Selected: Green, Unselected: Gray
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
            lineHeight = 12.sp,
            maxLines = 1 // Prevents text wrapping
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOverviewScreen() {
    GreenBridgeTheme {
        OverviewScreen()
    }
}
