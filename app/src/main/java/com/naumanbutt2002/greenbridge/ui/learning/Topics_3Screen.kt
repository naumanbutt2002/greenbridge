import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@Composable
fun Topics_3Screen() {
    // Remember the currently selected tab
    val selectedTab = remember { mutableStateOf(2) }
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


@Preview(showBackground = true)
@Composable
fun PreviewTopics_3Screen() {
    GreenBridgeTheme {
        Topics_3Screen()
    }
}
