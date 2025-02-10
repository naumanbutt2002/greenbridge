package com.naumanbutt2002.greenbridge.ui.syllabus.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.InterFontFamily

// Data class to hold navigation item data
data class NavigationItem(val title: String, val icon: Int)
@Composable
fun BottomNavigationBar(
    selectedItem: Int, // Pass the currently selected index
    onItemSelected: (Int) -> Unit // Callback to notify about selection changes
) {
    val items = listOf(
        NavigationItem("Home", R.drawable.ic_home),
        NavigationItem("Exams", R.drawable.ic_monitor),
        NavigationItem("Novels", R.drawable.novels),
        NavigationItem("Syllabus", R.drawable.ic_syllabus),
        NavigationItem("Manage", R.drawable.ic_manage)
    )

    // Wrapper Column to add top border
    Column {
        HorizontalDivider(
            thickness = 1.dp, // Thickness of the top border
            color = MaterialTheme.colorScheme.surfaceContainerLow // Color of the top border
        )
        NavigationBar(containerColor = MaterialTheme.colorScheme.onBackground) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title,
                                tint = if (index == selectedItem) MaterialTheme.colorScheme.scrim else MaterialTheme.colorScheme.surfaceContainerHigh,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.height(1.dp)) // 1.dp space between icon and text
                            Text(
                                text = item.title,
                                color = if (index == selectedItem) MaterialTheme.colorScheme.scrim else MaterialTheme.colorScheme.surfaceContainerHigh,
                                fontWeight = if (index == selectedItem) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                fontFamily = InterFontFamily,
                            )
                        }
                    },
                    selected = selectedItem == index,
                    onClick = { onItemSelected(index) }, // Notify parent about the selection
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent // Transparent background
                    )
                )
            }
        }
    }
}
