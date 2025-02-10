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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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


@Composable
fun PastQuestions() {
    // Remember the currently selected tab
    val selectedTab = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Top bar
        TopRow(
            title = "Basic Concept",
            onBackClick = { /* Handle back button click */ }
        )
        TopTabRowPastQuestions()

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 14.dp, bottom = 40.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=15.dp,end=15.dp,top=24.dp)
                )
                {

                    // Sections
                    // Tabs for Topics, Recently Read, and Bookmarked
                    PQ_TabsRow(selectedTab.value) { index ->
                        selectedTab.value = index
                    }

                    val PQ_questions = remember {
                        listOf(
                            PQ_Question(
                                titleText="WAEC SSCE- AGRICULTURAL SCIENCE - 2020",
                                questionNumber = 1,
                                questionText = "Who accompanied Paul on his first missionary journey?",
                                options = listOf("Resources are mismanaged by leaders", "There is no proper planning", "Resources are not in adequate supply", "The services of the economists are not employed"),
                                answer = "The services of the economists are not employed"
                            ),
                            PQ_Question(
                                titleText="WAEC SSCE- AGRICULTURAL SCIENCE - 2021",
                                questionNumber = 2,
                                questionText = "In what year was NASA established?",
                                options = listOf("1958", "1969", "1978", "1987"),
                                answer = "1958"
                            ),
                        )
                    }
                    val areAllSelected = remember { mutableStateOf(false) }

                    // Display content based on selected tab
                    when (selectedTab.value) {
                        0 -> PQ_SectionItem(PQ_questions = PQ_questions,
                            selected = areAllSelected.value,
                            onClick = { areAllSelected.value = !areAllSelected.value },)
                        1 -> PQ_SectionItem(PQ_questions = PQ_questions,
                            selected = areAllSelected.value,
                            onClick = { areAllSelected.value = !areAllSelected.value },)
                        2 -> PQ_SectionItem(PQ_questions = PQ_questions,
                            selected = areAllSelected.value,
                            onClick = { areAllSelected.value = !areAllSelected.value },)
                    }


                }

            }

        }

    }
}
@Composable
fun TopTabRowPastQuestions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemL("Recommended Books", isSelected = false)
        TabItemL("Evaluation", isSelected = false)
        TabItemL("Past Questions", isSelected = true)

    }
}
@Composable
fun PQ_TabsRow(selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onBackground)
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            // Topics Tab
            PQ_TabItem(
                title = "WAEC",
                isSelected = selectedIndex == 0,
                onClick = { onTabSelected(0) }
            )

            // Recently Read Tab
            PQ_TabItem(
                title = "JAMB",
                isSelected = selectedIndex == 1,
                onClick = { onTabSelected(1) }
            )

            // Bookmarked Tab
            PQ_TabItem(
                title = "NECO",
                isSelected = selectedIndex == 2,
                onClick = { onTabSelected(2) }
            )
        }
        // Box as Divider
        Box(
            modifier = Modifier
                .height(1.dp)
                .width(305.dp)
                .clip(RoundedCornerShape(0.dp))
                .background(MaterialTheme.colorScheme.outlineVariant)
        )
    }

}
@Composable
fun PQ_TabItem(title: String, isSelected: Boolean, onClick: () -> Unit) {
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
                    .width(67.dp)
                    .clip(RoundedCornerShape(1.dp))
                    .background(MaterialTheme.colorScheme.scrim)
            )

        }


    }
}

data class PQ_Question(
    val titleText: String,
    val questionNumber: Int,
    val questionText: String,
    val options: List<String>,
    val answer: String
)
@Composable
fun PQ_SectionItem(PQ_questions: List<PQ_Question>,

                   selected: Boolean,
                   onClick: () -> Unit,
                   modifier: Modifier = Modifier,
                   selectedColor: Color = MaterialTheme.colorScheme.primary, // Green for selected state
                   unselectedColor: Color = MaterialTheme.colorScheme.onBackground // Gray for unselected state
    ) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(PQ_questions) { index, question ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(vertical = 20.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center, // Ensures text is centered
                        modifier = Modifier
                            .height(32.dp) // Fixed height for all tabs
                            .defaultMinSize(minWidth = 321.dp) // Consistent minimum width for tabs
                            .background(
                                color = MaterialTheme.colorScheme.surfaceContainer,
                                shape = CircleShape // Rounded corners
                            )
                    ) {
                        Text(
                            text = question.titleText,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight(500),
                            fontSize = 10.sp,
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 15.sp,
                            maxLines = 1 // Prevents text wrapping
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row()
                    {
                        Text(
                            text = "Question ${question.questionNumber}",
                            color = MaterialTheme.colorScheme.scrim,
                            fontSize = 11.sp,
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = "Calculator",
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { /* Handle click */ }
                        )
                        Spacer(modifier = Modifier.width(14.dp))


                    }
                    Text(
                        text = question.questionText,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.scrim,
                        fontFamily = PoppinsFontFamily
                    )
                    // Options
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        question.options.forEachIndexed { optionIndex, option ->
                            Row (
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                // Dynamic RadioButton-like Circle
                                Box(
                                    modifier = modifier
                                        .size(12.dp) // Size of the clickable circle
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
                                            modifier = Modifier.size(9.dp) // Size of the checkmark
                                        )
                                    }
                                    else {
                                        // When not selected, display an empty center or some subtle design
                                        Box(
                                            modifier = Modifier
                                                .size(12.dp) // Optional: Inner circle size
                                                .clip(CircleShape)
                                                .background(MaterialTheme.colorScheme.onBackground)
                                                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape)
                                        )
                                    }
                                }
                                Text(
                                    text = option,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.tertiary,
                                    fontFamily = PoppinsFontFamily
                                )
                            }
                        }
                    }

                    Spacer(modifier = (Modifier.height(0.dp)))
                    // Answer
                    Row(horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.unfilled_eye),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = "View answer",
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.scrim,
                            fontFamily = PoppinsFontFamily
                        )
                    }
                }

                // Add a separator only if it's not the last item
                if (index < PQ_questions.size - 1) {
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceBright)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPastQuestions() {
    GreenBridgeTheme {
        PastQuestions()
    }
}
