



import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningScreen() {
    val searchState by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Learning",
            onBackClick = { /* Handle back button click */ },
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
//                .background(Color(0xFFFAFAFA))
                .background(MaterialTheme.colorScheme.surface)
                .padding(start = 20.dp, end = 20.dp, top = 0.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 16.dp, bottom = 10.dp)
            )
            {
                Text(
                    text = "Learning now made fun ",
                    color = MaterialTheme.colorScheme.scrim,
                    fontSize = 20.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Everything You Need to Excel in JAMB, WAEC, and NECO",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 12.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
                Row(
                    modifier = Modifier.padding(top=10.dp)
                )
                {
                    CustomButton(
                        text = "WAEC",
                        onClick = {},
                        buttonColor = MaterialTheme.colorScheme.primary, // Green background
                        contentColor = MaterialTheme.colorScheme.background,// White text
                        buttonWidth = 87.dp, // Custom button width
                        buttonHeight = 33.dp, // Custom button height
                        textFontSize = 10,
                        elevation = 0.dp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    CustomButton(
                        text = "JAMB",
                        onClick = {},
                        buttonColor = MaterialTheme.colorScheme.tertiaryContainer, //  background
                        contentColor = MaterialTheme.colorScheme.scrim,// White text
                        buttonWidth = 87.dp, // Custom button width
                        buttonHeight = 33.dp, // Custom button height
                        textFontSize = 10,
                        elevation = 0.dp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    CustomButton(
                        text = "NECO",
                        onClick = {},
                        buttonColor = MaterialTheme.colorScheme.tertiaryContainer, //  background
                        contentColor = MaterialTheme.colorScheme.scrim,// White text
                        buttonWidth = 87.dp, // Custom button width
                        buttonHeight = 33.dp, // Custom button height
                        textFontSize = 10,
                        elevation = 0.dp
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            Column (
                modifier = Modifier
                    .height(600.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=16.dp,end=16.dp,top=28.dp)
                )
                {

                    LearningSearchBar(searchState)
                    {

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        // Sections
                        LearningSectionItem(title = "English Language")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Agricultural science")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)

//                                .background(Color(0xFFF8F8F8))
                        )
                        LearningSectionItem(title = "Mathematics")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Health")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Insurance")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Marketing")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Chemistry")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Physics")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "Economics")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        LearningSectionItem(title = "French")
                    }


                }

            }

        }

    }
}

@Composable
fun LearningSearchBar(
    textState: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 0.dp),
    )
    {
        Box(
            modifier = Modifier
                .width(313.dp)
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
                        .padding(start = 4.dp)
                        .fillMaxWidth()
                ) {
                    // Placeholder when input is empty
                    if (textState.text.isEmpty()) {
                        Text(
                            text = "Search subjects",
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
}
@Composable
fun LearningSectionItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically // Aligns items vertically
    ) {
        // Left Column with Section and Title
        Column(
            modifier = Modifier.weight(1f)
        ) {
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
                .padding(end = 2.dp), // Small padding to separate from text
            contentDescription = "Forward Icon",
            tint = MaterialTheme.colorScheme.scrim
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLearningScreen() {
    GreenBridgeTheme {
        LearningScreen()
    }
}
