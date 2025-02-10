package com.naumanbutt2002.greenbridge.ui.exam


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.syllabus.components.BottomNavigationBar
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamsScreen() {
    var selectedItem by remember { mutableStateOf(1) } // Default selected item index
    val searchState by remember { mutableStateOf(TextFieldValue("")) }

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

                .background(MaterialTheme.colorScheme.surface)

        ) {
            TopTabRowE()
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                    .background(MaterialTheme.colorScheme.surface)
            ) {

                Column (
                    modifier = Modifier
                        .height(700.dp)
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
                            modifier = Modifier.padding(bottom = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "English (1996)",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = PoppinsFontFamily,
                                color = MaterialTheme.colorScheme.onSecondaryContainer

                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Image(
                                painter = painterResource(id = R.drawable.xcircle),
                                contentDescription = null,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Mathematics (2022)",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = PoppinsFontFamily,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Image(
                                painter = painterResource(id = R.drawable.xcircle),
                                contentDescription = null,
                                modifier = Modifier.size(12.dp)
                            )


                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        SearchBar(searchState)
                        {

                        }
                        Spacer(modifier = Modifier.height(25.dp))

                        ExamSelectionScreen()



                    }

                }

            }
        }
    }
}
data class SubTopic(
    val name: String,
    val isPremium: Boolean
)

data class ExamTopic(
    val title: String,
    val subTopics: List<SubTopic> = emptyList()
)

@Composable
fun ExamSelectionScreen() {
    val topics = listOf(
        ExamTopic(
            "English",
            listOf(
                SubTopic("1990", true),
                SubTopic("1991", false),
                SubTopic("1992", true),
                SubTopic("1993", false)
            )
        ),
        ExamTopic("History", listOf(
            SubTopic("Medieval", false),
            SubTopic("Modern", true)
        )),
        ExamTopic("Applied Arts", listOf(
            SubTopic("Painting", false),
            SubTopic("Sculpture", true)
        )),
        ExamTopic("Mathematics", listOf(
            SubTopic("Algebra", true),
            SubTopic("Geometry", false)
        )),
        ExamTopic("Music", listOf(
            SubTopic("Classical", true),
            SubTopic("Jazz", false)
        ))
    )


    val expandedStates = remember { topics.map { mutableStateOf(false) } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Top
        ) {
            items(topics.size) { index ->
                val topic = topics[index]
                ExamTopicItem(
                    title = topic.title,
                    isExpanded = expandedStates[index].value,
                    onExpandChange = { expandedStates[index].value = !expandedStates[index].value },
                    subTopics = topic.subTopics
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        CustomButton(
            text = "Continue",
            onClick = { },
            buttonColor = MaterialTheme.colorScheme.primary, // Green background
            contentColor = MaterialTheme.colorScheme.onBackground // White text
        )
    }
}


@Composable
fun ExamTopicItem(
    title: String,
    isExpanded: Boolean,
    onExpandChange: () -> Unit,
    subTopics: List<SubTopic> = emptyList()
) {
    val areAllSelected = remember { mutableStateOf(false) }

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
            CustomRadioButton(
                selected = areAllSelected.value,
                onClick = { areAllSelected.value = !areAllSelected.value },
                modifier = Modifier.padding(end = 8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                fontSize = 12.sp,
                color=MaterialTheme.colorScheme.scrim,
                fontWeight = FontWeight.Medium,
                fontFamily = PoppinsFontFamily
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint=MaterialTheme.colorScheme.scrim
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiaryContainer)
        )

        if (isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp)
            ) {
                Text(
                    text = "Year(s)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = PoppinsFontFamily,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 12.dp, bottom = 10.dp)
                )
                subTopics.forEach { subTopic ->
                    val isSelected = remember { mutableStateOf(false) }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 4.dp, bottom = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomRadioButton2(
                            selected = isSelected.value,
                            onClick = { isSelected.value = !isSelected.value },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = subTopic.name,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = PoppinsFontFamily,
                            modifier = Modifier.weight(1f),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        if (subTopic.isPremium) { // Only display "Premium" for premium subtopics
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(59.dp)
                                    .height(20.dp)
                                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(5.dp))
                            ) {
                                Text(
                                    text = "Premium",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = PoppinsFontFamily,
                                    modifier=Modifier.offset(y=(-2).dp),
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                )
            }
        }
    }
}

@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: Color = MaterialTheme.colorScheme.primary, // Green for selected state
    unselectedColor: Color = MaterialTheme.colorScheme.onBackground // Gray for unselected state
) {
    Box(
        modifier = modifier
            .size(24.dp) // Set the size of the RadioButton
            .clip(CircleShape)
            .background(if (selected) selectedColor else unselectedColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            // Display the checkmark when selected
            Icon(
                imageVector = Icons.Default.Check, // Material Design checkmark icon
                contentDescription = "Selected",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(14.dp) // Size of the checkmark
            )
        } else {
            // When not selected, display an empty center or some subtle design
            Box(
                modifier = Modifier
                    .size(20.dp) // Optional: Inner circle size
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onBackground)
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape) // Transparent center
            )
        }
    }
}

@Composable
fun CustomRadioButton2(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: Color = MaterialTheme.colorScheme.scrim, // Green for selected state
    unselectedColor: Color = MaterialTheme.colorScheme.onBackground // Gray for unselected state
) {
    Box(
        modifier = modifier
            .size(15.dp) // Set the size of the RadioButton
            .clip(CircleShape)
            .background(if (selected) selectedColor else unselectedColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            // Display the checkmark when selected
            Icon(
                imageVector = Icons.Default.Check, // Material Design checkmark icon
                contentDescription = "Selected",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(8.dp) // Size of the checkmark
            )
        } else {
            // When not selected, display an empty center or some subtle design
            Box(
                modifier = Modifier
                    .size(20.dp) // Optional: Inner circle size
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onBackground)
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape) // Transparent center
            )
        }
    }
}

@Composable
fun TopTabRowE() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 29.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemE("WAEC Questions","20000", isSelected = true)
        TabItemE("JAMB Questions","32000", isSelected = false)
        TabItemE("NECO Questions","20000", isSelected = false)
    }
}
@Composable
fun TabItemE(title: String,digit: String, isSelected: Boolean) {
    Box(
//        contentAlignment = Alignment.Center, // Ensures text is centered
        modifier = Modifier
            .height(35.dp) // Fixed height for all tabs
            .defaultMinSize(minWidth = 165.dp) // Consistent minimum width for tabs
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiaryContainer, // Selected: Green, Unselected: Gray
                shape = CircleShape // Rounded corners
            )
            .padding(horizontal = 16.dp, vertical = 8.dp) // Padding for internal content
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Text(
                text = title,
                color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.scrim, // Selected: White, Unselected: Dark Gray
                fontWeight = FontWeight(500),
                fontSize = 10.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 15.sp,
                maxLines = 1 // Prevents text wrapping
            )
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                contentAlignment = Alignment.Center, // Ensures text is centered
                modifier = Modifier
                    .height(17.dp) // Fixed height for all tabs
                    .width(46.dp) // Consistent minimum width for tabs
                    .background(
                        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondaryContainer, // Selected: Green, Unselected: Gray
                        shape = CircleShape // Rounded corners
                    )
            ) {
                Text(
                    text = digit,
                    color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.scrim, // Selected: White, Unselected: Dark Gray
                    fontWeight = FontWeight(500),
                    fontSize = 9.sp,
                    fontFamily = PoppinsFontFamily,
                    modifier = Modifier.offset(y=(-3).dp), // Padding for internal content,
                    maxLines = 1 // Prevents text wrapping
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ExamsScreenPreview() {
    GreenBridgeTheme {
        ExamsScreen()
    }
}
