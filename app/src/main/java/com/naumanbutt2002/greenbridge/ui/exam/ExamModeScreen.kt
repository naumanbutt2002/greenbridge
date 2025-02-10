package com.naumanbutt2002.greenbridge.ui.exam

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@SuppressLint("NewApi")
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HtmlText(
    htmlContent: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                setTextAppearance(android.R.style.TextAppearance_Medium)
            }
        },
        modifier = modifier,
        update = { textView ->
            textView.text = Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_COMPACT)
        }
    )
}

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamModeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {
        // Top Row: Back Button
        TopRow(
            title = "Exam Mode",
            onBackClick = { /* Handle back button click */ },
            rightContent = {
                Text(
                    text = "00:40:53",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsFontFamily,
                        color = Color.Black
                    ),
                    modifier = Modifier.clickable { /* Handle text click */ }
                )
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 17.dp)
                .background(Color(0xFFFAFAFA))
        ) {
            Column(
                modifier = Modifier
                    .height(452.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 14.dp, end = 14.dp, top = 20.dp)
                ) {
                    // Buttons for categories
                    Row(modifier = Modifier.padding(bottom = 16.dp)) {
                        CustomButton(
                            text = "English",
                            onClick = {},
                            buttonColor = Color(0xFF3D8543),
                            contentColor = Color.White,
                            buttonWidth = 100.dp,
                            buttonHeight = 30.dp,
                            textFontSize = 9,
                            elevation = 0.dp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        CustomButton(
                            text = "Commerce",
                            onClick = {},
                            buttonColor = Color(0xFFF2F2F2),
                            contentColor = Color.Black,
                            buttonWidth = 100.dp,
                            buttonHeight = 30.dp,
                            textFontSize = 9,
                            elevation = 0.dp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        CustomButton(
                            text = "Health",
                            onClick = {},
                            buttonColor = Color(0xFFF2F2F2),
                            contentColor = Color.Black,
                            buttonWidth = 100.dp,
                            buttonHeight = 30.dp,
                            textFontSize = 9,
                            elevation = 0.dp
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    // Question & Timer Icons
                    Row {
                        Text(
                            text = "Question 1/40",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontFamily = PoppinsFontFamily,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = R.drawable.calculator),
                            contentDescription = "Calculator",
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { /* Handle click */ }
                        )
                        Spacer(modifier = Modifier.width(12.8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = "Flag",
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { /* Handle click */ }
                        )
                        Spacer(modifier = Modifier.width(12.8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.groupicon),
                            contentDescription = "Group Icon",
                            modifier = Modifier
                                .width(21.33.dp)
                                .height(16.dp)
                                .clickable { /* Handle click */ }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(Color(0xFFF1F1F1))
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Render Question as HTML
                    HtmlText(
                        htmlContent = "<p><strong style='font-weight: 500;'>Who accompanied Paul on his first missionary journey?</strong></p>",
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Render Answer Options
                    RenderOption('a', "Matthew", false)
                    Spacer(modifier = Modifier.height(6.dp))

                    RenderOption('b', "<b>Silas</b>", true)
                    Spacer(modifier = Modifier.height(6.dp))

                    RenderOption('c', "Damascus", false)
                    Spacer(modifier = Modifier.height(6.dp))

                    RenderOption('d', "Judas", false)
                    Spacer(modifier = Modifier.height(6.dp))

                    Spacer(modifier = Modifier.height(12.dp))

                    // Navigation Buttons
                    Row(modifier = Modifier.fillMaxWidth()) {
                        CustomButton(
                            text = "Go back",
                            onClick = {},
                            buttonColor = Color(0xFFDAE9DB),
                            contentColor = Color(0xFF3D8543),
                            buttonWidth = 146.dp,
                            buttonHeight = 28.dp,
                            textFontSize = 10,
                            elevation = 5.dp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        CustomButton(
                            text = "Next",
                            onClick = {},
                            buttonColor = Color(0xFF3D8543),
                            contentColor = Color.White,
                            buttonWidth = 146.dp,
                            buttonHeight = 28.dp,
                            textFontSize = 10,
                            elevation = 5.dp
                        )
                    }
                }
            }
        }
    }
}

@SuppressLint("NewApi")
@Composable
fun RenderOption(optionChar: Char, htmlContent: String, isSelected: Boolean) {
    Row(
        modifier = Modifier
            .height(35.dp)
            .fillMaxWidth()
            .border(
                if (isSelected) 1.dp else 0.dp,
                if (isSelected) Color.Black else Color.White,
                RoundedCornerShape(25.dp)
            )
            .background(
                color = if (isSelected) Color(0xFFF4F4F4) else Color(0xFFF8F8F8),
                shape = CircleShape
            )
            .padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(27.dp)
                .background(
                    color = if (isSelected) Color.Black else Color(0xFFE3E3E3),
                    shape = CircleShape
                )
        ) {
            Text(
                text = optionChar.toString(),
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                color = if (isSelected) Color.White else Color.Black,
                fontFamily = PoppinsFontFamily
            )
        }
        HtmlText(
            htmlContent = htmlContent,
            modifier = Modifier
                .padding(start = 6.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExamModeScreen() {
    GreenBridgeTheme {
        ExamModeScreen()
    }
}
