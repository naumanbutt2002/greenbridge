import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@Composable
fun Topics_1Screen() {
    // Remember the currently selected tab
    val selectedTab = remember { mutableStateOf(0) }
    val searchState by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Top bar
        TopRow(
            title = "Learning",
            onBackClick = { /* Handle back button click */ }
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 14.dp, bottom = 40.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=16.dp,end=16.dp,top=19.dp)
                )
                {

                    TopicsSearchBar(searchState)
                    {

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    // Sections
                    // Tabs for Topics, Recently Read, and Bookmarked
                    TabsRow(selectedTab.value) { index ->
                        selectedTab.value = index
                    }

                    Spacer(modifier = Modifier.height(21.dp))

                    // Display content based on selected tab
                    when (selectedTab.value) {
                        0 -> TopicsContent()
                        1 -> RecentlyReadContent()
                        2 -> BookmarkedContent()
                    }


                }

            }

        }

    }
}


@Composable
fun TopicsSearchBar(
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
                            text = "Search topics",
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
fun TabsRow(selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onBackground)
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            // Topics Tab
            TabItem(
                title = "Topics",
                isSelected = selectedIndex == 0,
                onClick = { onTabSelected(0) }
            )

            // Recently Read Tab
            TabItem(
                title = "Recently Read",
                isSelected = selectedIndex == 1,
                onClick = { onTabSelected(1) }
            )

            // Bookmarked Tab
            TabItem(
                title = "Bookmarked",
                isSelected = selectedIndex == 2,
                onClick = { onTabSelected(2) }
            )
        }
        // Box as Divider
        Box(
            modifier = Modifier
                .height(1.dp)
                .width(320.dp)
                .clip(RoundedCornerShape(0.dp))
                .background(MaterialTheme.colorScheme.outlineVariant)
        )
    }

}

@Composable
fun TabItem(title: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(2.dp))
            .clickable(onClick = onClick)
    ) {
        Text(
            text = title,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = PoppinsFontFamily,
            color = if (isSelected) MaterialTheme.colorScheme.scrim else MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        if (isSelected) {
            // Highlight line below the selected tab
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(82.dp)
                    .clip(RoundedCornerShape(1.dp))
                    .background(MaterialTheme.colorScheme.scrim)
            )

        }


    }
}
@Composable
fun SectionItem(
    title: String,
    section: String,
    isStarFilled: Boolean,
    starColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.inverseSurface)
//            .background(Color(0xFFFCFCFC))
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically // Aligns items vertically
    ) {
        // Left Column with Section and Title
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = section,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 11.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 17.sp,
                fontWeight = FontWeight(500)
            )

            Text(
                text = title,
                color = MaterialTheme.colorScheme.scrim,
                fontSize = 12.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500)
            )
        }

        // Dynamic Star Icon
        Icon(
            imageVector = if (isStarFilled) Icons.Filled.Star else Icons.Default.StarBorder,
            modifier = Modifier.size(16.dp), // Adjust size of the star icon
            contentDescription = "Star Icon",
            tint = starColor
        )
    }
}
@Composable
fun RecentlyRead_SectionItem(
    title: String,
    section: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedColor: Color = MaterialTheme.colorScheme.primary, // Green for selected state
    unselectedColor: Color = MaterialTheme.colorScheme.onBackground // Gray for unselected state
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.inverseSurface)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically // Aligns items vertically
    ) {
        // Left Column with Section and Title
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = section,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 11.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 17.sp,
                fontWeight = FontWeight(500)
            )

            Text(
                text = title,
                color = MaterialTheme.colorScheme.scrim,
                fontSize = 12.sp,
                fontFamily = PoppinsFontFamily,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500)
            )
        }

        // Dynamic RadioButton-like Circle
        Box(
            modifier = modifier
                .size(16.dp) // Size of the clickable circle
                .clip(CircleShape)
                .background(if (selected) selectedColor else unselectedColor)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            if (selected) {
                Icon(
                    imageVector = Icons.Default.Check, // Material Design checkmark icon
                    contentDescription = "Selected",
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(12.dp) // Size of the checkmark
                )
            }
            else {
                // When not selected, display an empty center or some subtle design
                Box(
                    modifier = Modifier
                        .size(12.dp) // Optional: Inner circle size
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onBackground)
                        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape) // Transparent center

//                        .border(1.dp, Color(0xFFD1D0D0), CircleShape) // Transparent center
                )
            }
        }
    }
}
@Composable
fun RecentlyReadContent() {
    // State to hold the selected section indices (allowing multiple selections)
    val selectedSectionIndices = remember { mutableStateOf(setOf<Int>()) }

    // List of topics, corresponding sections
    val topicsWithDetails = listOf(
        "Basic concept of Agricultural Science" to "Section 1",
        "Agricultural Ecology" to "Section 2",
        "Agricultural Engineering/Mechanization" to "Section 3",
        "Plants" to "Section 4",
        "Animal Husbandry" to "Section 5",
        "Ecology II" to "Section 6",
        "Storage facilities" to "Section 7",
        "Soil Fertility" to "Section 8"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(topicsWithDetails) { index, (topic, section) ->
            RecentlyRead_SectionItem(
                title = topic,
                section = section,
                selected = selectedSectionIndices.value.contains(index), // Check if index is selected
                onClick = {
                    // Toggle the selected state of the section
                    selectedSectionIndices.value = if (selectedSectionIndices.value.contains(index)) {
                        selectedSectionIndices.value - index // Deselect
                    } else {
                        selectedSectionIndices.value + index // Select
                    }
                }
            )
        }
    }
}

@Composable
fun TopicsContent() {
    // List of topics, corresponding sections, star status, and star colors
    val topicsWithDetails = listOf(
        Triple("Basic concept of Agricultural Science", "Section 1", Pair(true, MaterialTheme.colorScheme.scrim)), // Filled yellow star
        Triple("Agricultural Ecology", "Section 2", Pair(false, MaterialTheme.colorScheme.surfaceVariant)), // Unfilled gray star
        Triple("Agricultural Engineering/Mechanization", "Section 3", Pair(true, MaterialTheme.colorScheme.scrim)),
        Triple("Plants", "Section 4", Pair(false, MaterialTheme.colorScheme.surfaceVariant)),
        Triple("Animal Husbandry", "Section 5", Pair(true, MaterialTheme.colorScheme.scrim)),
        Triple("Ecology II", "Section 6", Pair(false, MaterialTheme.colorScheme.surfaceVariant)),
        Triple("Storage facilities", "Section 7", Pair(true, MaterialTheme.colorScheme.scrim)),
        Triple("Soil Fertility", "Section 8", Pair(false, MaterialTheme.colorScheme.surfaceVariant))
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topicsWithDetails) { (topic, section, starInfo) ->
            SectionItem(title = topic, section = section, isStarFilled = starInfo.first, starColor = starInfo.second)
        }
    }
}


@Composable
fun BookmarkedContent() {
    val topicsWithDetails = listOf(
        Triple("Basic concept of Agricultural Science", "Section 1", Pair(true, MaterialTheme.colorScheme.scrim)), // Filled yellow star
        Triple("Agricultural Ecology", "Section 2", Pair(true, MaterialTheme.colorScheme.scrim)), // Unfilled gray star
        Triple("Agricultural Engineering/Mechanization", "Section 3", Pair(true, MaterialTheme.colorScheme.scrim)),
        Triple("Plants", "Section 4", Pair(true, MaterialTheme.colorScheme.scrim)),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topicsWithDetails) { (topic, section, starInfo) ->
            SectionItem(title = topic, section = section, isStarFilled = starInfo.first, starColor = starInfo.second)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopics_1Screen() {
    GreenBridgeTheme {
        Topics_1Screen()
    }
}
