package com.naumanbutt2002.greenbridge.ui.timetable.commponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun TopRow(
    title: String,
    onBackClick: () -> Unit,
    rightContent: (@Composable (() -> Unit))? = null // Lambda for custom composable content
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .padding(start = 20.dp, end = 20.dp, top = 15.dp, bottom = 25.dp)
    ) {
        // Back Button Image aligned to the start
        Box(
            modifier = Modifier
                .size(24.dp)
                .clickable {  onBackClick()}
                .clip(RoundedCornerShape(10)) // Fully rounded corners
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                )
                .border(1.dp, MaterialTheme.colorScheme.onTertiaryContainer, RoundedCornerShape(1.dp)) ,
            contentAlignment = Alignment.Center

        )
        {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Arrow Back",
                tint = MaterialTheme.colorScheme.scrim,

                )
        }

        // Centered Text Title
        Text(
            text = title,
            fontFamily = PoppinsFontFamily,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.scrim,
            style = TextStyle(fontSize = 13.sp, color = Color.Black),
            modifier = Modifier.align(Alignment.Center)
        )

        // Optional Right-Side Content aligned to the end
        if (rightContent != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                rightContent()
            }
        }
    }
}

