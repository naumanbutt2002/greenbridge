



import androidx.compose.foundation.Image
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
fun SearchResults() {
    val searchState by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Search",
            onBackClick = { /* Handle back button click */ },
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 14.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {

            Column (
                modifier = Modifier
                    .height(406.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=16.dp,end=16.dp,top=19.dp)
                )
                {

                    SearchResultsSearchBar(searchState)
                    {}

                    Spacer(modifier = Modifier.height(6.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        // Sections
                        SearchResultsSectionItem(title = "Horticulture I")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        SearchResultsSectionItem(title = "Horticulture II")
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outline)
                        )
                        SearchResultsSectionItem(title = "Holocaust")

                    }

                }

            }

        }

    }
}

@Composable
fun SearchResultsSearchBar(
    textState: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 0.dp),
    )
    {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50)) // Fully rounded corners
                .fillMaxWidth()
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
                ) {
                    // Placeholder when input is empty
                    if (textState.text.isEmpty()) {
                        Text(
                            text = "Hor|",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight(500),
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 16.5.sp,
                            fontSize = 11.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.xcircle),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }


    }
}
@Composable
fun SearchResultsSectionItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
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

    }

}
@Preview(showBackground = true)
@Composable
fun PreviewSearchResults() {
    GreenBridgeTheme {
        SearchResults()
    }
}
