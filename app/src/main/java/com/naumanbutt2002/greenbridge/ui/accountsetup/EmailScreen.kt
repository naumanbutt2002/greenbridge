package com.naumanbutt2002.greenbridge.ui.accountsetup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomTextField
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.SegmentedProgressBar
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.theme.onSurfaceVariantLight

@Composable
fun EmailScreen(
    onContinue: () -> Unit,
    onSkip: () -> Unit
) {
    val name by remember { mutableStateOf("Email") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
            .padding(20.dp)

    ) {
        // Top Row: Back Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.5.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
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
        }
        // Segmented Progress Bar
        SegmentedProgressBar(
            currentStep = 0, // Replace with the dynamic step
            totalSteps = 4,
            activeColor = MaterialTheme.colorScheme.primary, // Green for completed step
            inactiveColor = MaterialTheme.colorScheme.onSurfaceVariant, // Light gray for remaining steps
            spacing = 2.dp // Matches design spacing
        )
//        Spacer(modifier = Modifier.height(38.dp)) // Space between progress and content

        // Title Section
        Column(
            modifier = Modifier
                .padding(top = 38.dp, bottom = 60.dp)
        ){
            Text(
                text = "Email Address",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.scrim,
                    lineHeight = 28.sp,
                    fontFamily = PoppinsFontFamily
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp)) // Space below title

            Text(
                text = "Please enter your correct email",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight(500),
                    fontFamily = PoppinsFontFamily,
                    lineHeight = 21.sp,



                    ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(28.dp)) // Space below description

            // Name Input Field
            CustomTextField(
                text = name,
                onTextChange = {},
                textColor=MaterialTheme.colorScheme.onSurfaceVariant,
                lineColor=MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }


        // Continue Button
        CustomButton(
            text = "Continue",
            onClick = onContinue,
            buttonColor = MaterialTheme.colorScheme.primary, // Green background
            contentColor = MaterialTheme.colorScheme.onBackground // White text
        )

        Spacer(modifier = Modifier.height(42.dp)) // Space between buttons

        // Skip Button
        TextButton(
            onClick = onSkip,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Skip",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary, // Green color for skip
                    fontWeight = FontWeight(600),
                    lineHeight = 21.sp,
                    fontFamily = PoppinsFontFamily,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEmailScreen() {
    GreenBridgeTheme{
        EmailScreen(
            onContinue = { /* Handle continue */ },
            onSkip = { /* Handle skip */ }
        )
    }

}
