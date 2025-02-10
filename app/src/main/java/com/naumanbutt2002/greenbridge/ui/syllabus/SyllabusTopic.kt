package com.naumanbutt2002.greenbridge.ui.syllabus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily

@Composable
fun SectionTopic() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f)) // Full Screen Background
    ) {
        // Top 40% Syllabus Section with Blur applied from Parent
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(0.5.dp)

        ) {
            SyllabusSection()
        }
        SyllabusDialog()


    }
}

@Composable
fun SyllabusDialog() {
    var showDialog by remember { mutableStateOf(true) }


    if (showDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000))
        ) {
            // Bottom 60% Section Content
            Box(
                modifier = Modifier
                    .width(393.dp)
                    .height(519.dp)
                    .offset(y = (0.4f * LocalConfiguration.current.screenHeightDp).dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    ) // Rounds top-left and top-right corners
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 35.dp, vertical = 30.dp)
                ) {
                    // Expandable Header with Icon
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Collapse Icon",
                            tint = MaterialTheme.colorScheme.scrim,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = "Section 2 : AGRICULTURAL ECOLOGY",
                            fontFamily = PoppinsFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.scrim,
                            lineHeight = 20.sp
                        )
                    }

                    // Topic Title
                    Text(
                        text = "Topic 1: Meaning and Importance of Agriculture Ecology",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.scrim,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 30.dp)
                    )

                    // Subtopics Section
                    Text(
                        text = "Subtopic(s)",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.scrim,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    val subtopics = listOf(
                        "Meaning of Agricultural Ecology And Ecosystem",
                        "Components of Farm Ecosystem e.g Biotic and Abiotic",
                        "Interactions of the Components in the Terrestrial And Aquatic Agro-Ecosystem"
                    )

                    subtopics.forEachIndexed { index, subtopic ->
                        Text(
                            text = "${index + 1}. $subtopic",
                            fontFamily = PoppinsFontFamily,
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.inverseOnSurface,
                            modifier = Modifier.padding(start = 14.dp, bottom = 8.dp)
                        )
                    }

                    // Objective(s) Section
                    Text(
                        text = "Objective(s)",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.scrim,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Text(
                        text = "1. None",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier.padding(start = 14.dp)
                    )

                    // Note Section
                    Text(
                        text = "Note",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.scrim,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Text(
                        text = "1. Interaction of the farm crops/animals with other components of the ecosystem in the farm settings such as mono or sole cropping system, mixed cropping system, mixed farming system, fish ponds and forest",
                        fontFamily = PoppinsFontFamily,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier.padding(start = 14.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSectionTopic() {
    GreenBridgeTheme {
        SectionTopic()
    }
}
