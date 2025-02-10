package com.naumanbutt2002.greenbridge.ui.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Notifications",
            onBackClick = { /* Handle back button click */ },
        )
        // List of Notifications
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp) // Spacing between items
        ) {
            item {
                NotificationItem(
                    title = "Join our Whatsapp channel",
                    description = "Get latest updates on WAEC, JAMB and NECO and many more",
                    date = "23, Nov"
                )
            }
            item {
                NotificationItem(
                    title = "Upgrade to premium",
                    description = "Enjoy full benefit of the app by subscribing to the premium",
                    date = "15, Nov"
                )
            }
        }
    }
}


@Composable
fun NotificationItem(title: String, description: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 16.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        // Left Side: Icon + Title + Description
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.Top) {
            // Notification Icon with Circular Background
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0xFFF5F5F5), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification), // Replace with your drawable
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(modifier = Modifier.width(5.dp)) // Spacing between icon and text

            // Title and Description
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF3E3E3E)
                    ),
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = PoppinsFontFamily,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFFA4A4A4)
                    ),
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = PoppinsFontFamily,
                    maxLines = 2, // Prevent description from overflowing
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Right Side: Date at the Top
        Text(
            text = date,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color(0xFF858484) // Slightly darker gray for date
            ),
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = PoppinsFontFamily,
            modifier = Modifier.align(Alignment.Top)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewNotificationsScreen() {
    GreenBridgeTheme {
        NotificationsScreen()
    }
}
