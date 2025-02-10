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
import androidx.compose.material.icons.filled.ThumbDownOffAlt
import androidx.compose.material.icons.filled.ThumbUpAlt
import androidx.compose.material.icons.filled.ThumbUpOffAlt
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
fun LessonNotes() {
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
        TopTabRowLessonNotes()

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {

            Column (
                modifier = Modifier
//                    .height(560.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=15.dp,end=15.dp,top=28.dp)
                )
                {

                    Column(modifier = Modifier.padding(bottom = 12.dp))
                    {
                        Row(
                            horizontalArrangement = Arrangement.Absolute.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        {
                            Text(
                                text = "Lesson Objective",
                                color = MaterialTheme.colorScheme.scrim,
                                fontWeight = FontWeight(500),
                                fontSize = 13.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            fontFamily = PoppinsFontFamily,
                            textAlign = TextAlign.Center,
                            lineHeight = 22.sp
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceBright)
                    )
                    Column(modifier = Modifier.padding(top = 12.dp))
                    {
                        Row(
                            horizontalArrangement = Arrangement.Absolute.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        {
                            Text(
                                text = "Lesson Plans",
                                color = MaterialTheme.colorScheme.scrim,
                                fontWeight = FontWeight(500),
                                fontSize = 13.sp,
                                fontFamily = PoppinsFontFamily,
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            fontFamily = PoppinsFontFamily,
                            textAlign = TextAlign.Center,
                            lineHeight = 22.sp

                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp),

                    )
                    {
                        Text(
                            text="Did you find explanation helpful?",
                            color = MaterialTheme.colorScheme.scrim,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                            textAlign = TextAlign.Center,
                            lineHeight = 15.sp,

                        )
                        Row(
                            horizontalArrangement = Arrangement.Absolute.Center,
                            modifier = Modifier.fillMaxWidth())
                        {
                            Icon(
                                imageVector = Icons.Default.ThumbUpOffAlt,
                                modifier = Modifier
                                    .size(16.dp),
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(12.dp)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(16.dp)
                                    .background(MaterialTheme.colorScheme.surfaceBright)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(12.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.ThumbDownOffAlt,
                                modifier = Modifier
                                    .size(16.dp), // Adjust size of the arrow
                                contentDescription = "Thumbs Up",
                                tint = MaterialTheme.colorScheme.scrim
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column (
                modifier = Modifier
                    .height(133.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                        .padding(start=15.dp,end=15.dp,top=16.dp)
                )
                {
                    Text(
                        text = "Related Topics",
                        color = MaterialTheme.colorScheme.scrim,
                        fontWeight = FontWeight(500),
                        fontSize = 11.sp,
                        fontFamily = PoppinsFontFamily,
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        Text(
                            text = "Horticulture I",
                            color = MaterialTheme.colorScheme.onTertiary,
                            fontWeight = FontWeight(500),
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                        )
                        Text(
                            text = "Horticulture II",
                            color = MaterialTheme.colorScheme.onTertiary,
                            fontWeight = FontWeight(500),
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                        )
                        Text(
                            text = "Holocaust",
                            color = MaterialTheme.colorScheme.onTertiary,
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
@Composable
fun TopTabRowLessonNotes() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemL("Overview", isSelected = false)
        TabItemL("Videos", isSelected = false)
        TabItemL("Lesson Plans", isSelected = true)
        TabItemL("Recommended Books", isSelected = false)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLessonNotes() {
    GreenBridgeTheme {
        LessonNotes()
    }
}
