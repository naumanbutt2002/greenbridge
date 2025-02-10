import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow


@Composable
fun EvaluationScreen() {
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
        TopTabRowEvaluation()

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
                    El_TabsRow(selectedTab.value) { index ->
                        selectedTab.value = index
                    }

                    val questions = remember {
                        listOf(
                            Question(
                                questionNumber = 1,
                                questionText = "The largest component of national income in developing countries consists of",
                                options = listOf("Solyphere", "Elements", "Ice", "All of the above"),
                                answer = "Solyphere"
                            ),
                            Question(
                                questionNumber = 2,
                                questionText = "The smallest unit of matter is",
                                options = listOf("Atom", "Molecule", "Electron", "Proton"),
                                answer = "Atom"
                            ),
                            Question(
                                questionNumber = 3,
                                questionText = "Which planet is closest to the Sun?",
                                options = listOf("Mercury", "Venus", "Earth", "Mars"),
                                answer = "Mercury"
                            )
                        )
                    }
                    // Display content based on selected tab
                    when (selectedTab.value) {
                        0 -> El_SectionItem(questions = questions)
                        1 -> El_SectionItem(questions = questions)
                        2 -> El_SectionItem(questions = questions)
                    }


                }

            }

        }

    }
}
@Composable
fun TopTabRowEvaluation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemL("Lesson Plans", isSelected = false)
        TabItemL("Recommended Books", isSelected = false)
        TabItemL("Evaluation", isSelected = true)

    }
}
@Composable
fun El_TabsRow(selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onBackground)
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Topics Tab
            El_TabItem(
                title = "Multiple choice Questions",
                isSelected = selectedIndex == 0,
                onClick = { onTabSelected(0) }
            )

            // Recently Read Tab
            El_TabItem(
                title = "Essay Questions",
                isSelected = selectedIndex == 1,
                onClick = { onTabSelected(1) }
            )

            // Bookmarked Tab
            El_TabItem(
                title = "Short Qs",
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
fun El_TabItem(title: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
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
                    .width(130.dp)
                    .clip(RoundedCornerShape(1.dp))
                    .background(MaterialTheme.colorScheme.scrim)
            )

        }


    }
}

data class Question(
    val questionNumber: Int,
    val questionText: String,
    val options: List<String>,
    val answer: String
)
@Composable
fun El_SectionItem(questions: List<Question>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(questions) { index, question ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    // Question Header
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(20.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.scrim,
                                    shape = CircleShape
                                )
                        ) {
                            Text(
                                text = question.questionNumber.toString(),
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontFamily = PoppinsFontFamily
                            )
                        }
                        Text(
                            text = question.questionText,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.scrim,
                            fontFamily = PoppinsFontFamily
                        )
                    }

                    // Options
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        question.options.forEachIndexed { optionIndex, option ->
                            Row {
                                Text(
                                    text = "${'A' + optionIndex}. ",
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 11.sp,
                                    color =MaterialTheme.colorScheme.tertiary,
                                    fontFamily = PoppinsFontFamily
                                )
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

                    // Answer
                    Row {
                        Text(
                            text = "Answer: ",
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.scrim,
                            fontFamily = PoppinsFontFamily
                        )
                        Text(
                            text = question.answer,
                            fontWeight = FontWeight.Medium,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.scrim,
                            fontFamily = PoppinsFontFamily
                        )
                    }
                }

                // Add a separator only if it's not the last item
                if (index < questions.size - 1) {
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
fun PreviewEvaluationScreen() {
    GreenBridgeTheme {
        EvaluationScreen()
    }
}
