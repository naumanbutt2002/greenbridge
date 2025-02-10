package com.naumanbutt2002.greenbridge.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.OpenInNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily


@Composable
fun SearchBar(
    textState: String,
    onValueChange: (String) -> Unit,
    placeholderText: String = "Search courses",
    placeholderColor: Color = Color(0xFFA4A4A4),
    showSearchIcon: Boolean = true // Flag to show or hide the search icon
) {
    var isFilterMenuExpanded by remember { mutableStateOf(false) } // State for filter menu visibility

    Row(
        modifier = Modifier.padding(horizontal = 20.dp),
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .padding(horizontal = 4.dp)
                .clip(RoundedCornerShape(50)) // Fully rounded corners
                .background(Color(0xFFF5F5F5)) // Light gray background
                .padding(horizontal = 16.dp, vertical = 12.dp) // Add padding
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Show Search Icon if the flag is true
                if (showSearchIcon) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = Modifier.size(16.dp) // Adjust icon size
                    )
                }

                // Placeholder and Input Text
                BasicTextField(
                    value = textState,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 11.sp),
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .fillMaxWidth()
                ) {
                    // Placeholder when input is empty
                    if (textState.isEmpty()) {
                        Text(
                            text = placeholderText,
                            color = placeholderColor,
                            fontWeight = FontWeight(500),
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 16.5.sp,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(
                    color = Color(0xFFF2F1F1),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            // Filter Icon
            Icon(
                painter = painterResource(id = R.drawable.ic_search_filter),
                contentDescription = "Filter Icon",
                modifier = Modifier
                    .size(16.dp)
                    .clickable { isFilterMenuExpanded = true }, // Toggle filter menu
                tint = Color.Black
            )


            DropdownMenu(
                expanded = isFilterMenuExpanded,
                onDismissRequest = { isFilterMenuExpanded = false },
                modifier = Modifier.background(Color.White) // Set background color for the menu

            ) {
                // Example of a custom style
                val customTextStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontFamily = PoppinsFontFamily,
                    textAlign = TextAlign.Start
                )
                // First section
                DropdownMenuItem(
                    text = { Text("Filter by Date", style = customTextStyle) },
                    leadingIcon = { Icon(Icons.Outlined.DateRange, contentDescription = null) },
                    onClick = { /* Do something... */ }
                )
                DropdownMenuItem(
                    text = { Text("Filter by Subject", style = customTextStyle) },
                    leadingIcon = { Icon(Icons.Outlined.Book, contentDescription = null) },
                    onClick = { /* Do something... */ }
                )

                // Third section
                DropdownMenuItem(
                    text = { Text("Filter by Priority", style = customTextStyle) },
                    leadingIcon = { Icon(Icons.Outlined.Info, contentDescription = null) },
                    onClick = { /* Do something... */ }
                )
                DropdownMenuItem(
                    text = { Text("Help", style = customTextStyle) },
                    leadingIcon = { Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null) },
                    trailingIcon = { Icon(Icons.AutoMirrored.Outlined.OpenInNew, contentDescription = null) },
                    onClick = { /* Do something... */ }
                )
            }
        }
    }
}


