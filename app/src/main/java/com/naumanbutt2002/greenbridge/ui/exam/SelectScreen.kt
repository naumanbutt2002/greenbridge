
package com.naumanbutt2002.greenbridge.ui.exam



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.text.font.FontWeight
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow
import androidx.compose.foundation.layout.Spacer as Spacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectScreen() {
    val searchState by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        // Top Row: Back Button
        TopRow(
            title = "English",
            onBackClick = { /* Handle back button click */ },
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp, top = 0.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 16.dp, bottom = 13.dp)
            )
            {
                Text(
                    text = "Learning is more fun",
                    color = MaterialTheme.colorScheme.scrim,
                    fontSize = 20.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Select your preferred topic for the questions",
                    color = Color(0xFFB5B5B5),
                    fontSize = 11.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
            Column (
                modifier = Modifier
                    .height(645.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=14.dp,end=14.dp,top=20.dp)
                )
                {
                    Row(
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    {
                        CustomButton(
                            text = "English",
                            onClick = {},
                            buttonColor = MaterialTheme.colorScheme.primary, // Green background
                            contentColor = MaterialTheme.colorScheme.onBackground,// White text
                            buttonWidth = 100.dp, // Custom button width
                            buttonHeight = 30.dp, // Custom button height
                            textFontSize = 9,
                            elevation = 0.dp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        CustomButton(
                            text = "Commerce",
                            onClick = {},
                            buttonColor = MaterialTheme.colorScheme.tertiaryContainer, //  background
                            contentColor = MaterialTheme.colorScheme.scrim,// White text
                            buttonWidth = 100.dp, // Custom button width
                            buttonHeight = 30.dp, // Custom button height
                            textFontSize = 9,
                            elevation = 0.dp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        CustomButton(
                            text = "Health",
                            onClick = {},
                            buttonColor = MaterialTheme.colorScheme.tertiaryContainer, //  background
                            contentColor = MaterialTheme.colorScheme.scrim,// White text
                            buttonWidth = 100.dp, // Custom button width
                            buttonHeight = 30.dp, // Custom button height
                            textFontSize = 9,
                            elevation = 0.dp
                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    SearchBar(searchState)
                    {

                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    TopicsSelectionScreen()



                }

            }

        }

    }
}

@Composable
fun SearchBar(
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
}

@Composable
fun TopicsSelectionScreen() {
    val comprehensionExpanded = remember { mutableStateOf(false) }
    val englishWritingExpanded = remember { mutableStateOf(false) }
    val englishNovelsExpanded = remember { mutableStateOf(false) }
    val lexisStructureExpanded = remember { mutableStateOf(false) }
    val oralFormsExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
//        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
//            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                TopicItem(
                    title = "Comprehension",
                    isExpanded = comprehensionExpanded.value,
                    onExpandChange = { comprehensionExpanded.value = !comprehensionExpanded.value },
                    subTopics = listOf("Reading", "Comprehensive passage", "Registers")
                )
            }

            item {
                TopicItem(
                    title = "English Writing",
                    isExpanded = englishWritingExpanded.value,
                    onExpandChange = { englishWritingExpanded.value = !englishWritingExpanded.value }
                )
            }

            item {
                TopicItem(
                    title = "English Novels",
                    isExpanded = englishNovelsExpanded.value,
                    onExpandChange = { englishNovelsExpanded.value = !englishNovelsExpanded.value }
                )
            }

            item {
                TopicItem(
                    title = "Lexis & Structure",
                    isExpanded = lexisStructureExpanded.value,
                    onExpandChange = { lexisStructureExpanded.value = !lexisStructureExpanded.value }
                )
            }

            item {
                TopicItem(
                    title = "Oral Forms",
                    isExpanded = oralFormsExpanded.value,
                    onExpandChange = { oralFormsExpanded.value = !oralFormsExpanded.value }
                )
            }
        }
        Spacer(modifier=Modifier.height(25.dp))

        CustomButton(
            text = "Continue",
            onClick = { },
            buttonColor = MaterialTheme.colorScheme.primary, // Green background
            contentColor = MaterialTheme.colorScheme.onBackground // White text
        )
    }
}

@Composable
fun TopicItem(
    title: String,
    isExpanded: Boolean,
    onExpandChange: () -> Unit,
    subTopics: List<String> = emptyList()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onExpandChange() }
                .padding(start = 1.5.dp, end = 18.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = false, // Handle the selected state as needed
                onClick = { /* Handle SubTopic Selection */ },
                modifier=Modifier.size(6.dp),
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF2ECC71), // Green color when selected
                    unselectedColor = Color(0xFFD1D0D0), // Gray color when unselected
                )
            )
            Spacer(modifier=Modifier.width(20.dp))

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = PoppinsFontFamily
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null
            )
        }
            Spacer(modifier= Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xFFF6F6F6)))

        if (isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp)
            ) {
                Text(
                    text = "Sub-topics",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = PoppinsFontFamily,
                    color = Color(0xFFA1A1A1),
                    modifier=Modifier.padding(top = 12.dp, bottom = 10.dp)

                )
                subTopics.forEach { subTopic ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 4.dp, bottom = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = false, // Handle the selected state as needed
                            onClick = { /* Handle SubTopic Selection */ },
                            modifier=Modifier.size(10.dp),
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF2ECC71), // Green color when selected
                                unselectedColor = Color(0xFFD1D0D0), // Gray color when unselected
                            )
                        )
                        Spacer(modifier=Modifier.width(10.dp))

                        Text(
                            text = subTopic,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = PoppinsFontFamily,
                            modifier = Modifier.weight(1f),
                            color = Color(0xFF666666)

                            )
                    }
                    Spacer(modifier=Modifier.height(16.dp))

                }
                Spacer(modifier= Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6F6)))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectScreen() {
    GreenBridgeTheme {
        SelectScreen()
    }
}
