package com.naumanbutt2002.greenbridge.ui.exam





import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.accountsetup.components.CustomButton
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mode_2Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Practice Mode",
            onBackClick = { /* Handle back button click */ },
            rightContent = {
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 7.dp), // Elevation
                    shape = CircleShape, // Rounded corners
                    colors = CardDefaults.cardColors(containerColor = Color.Black), // Set background color
                    modifier = Modifier
                        .height(28.dp)
                        .width(72.dp)

                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Done",
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = Color.White,
                            fontFamily = PoppinsFontFamily
                        )
                    }
                }

            }
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 17.dp)
                .background(Color(0xFFFAFAFA))
        ) {

            Column (
                modifier = Modifier
                    .height(553.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start=14.dp,end=14.dp,top=28.dp)
                )
                {

                    Row()
                    {
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
                            contentDescription = "Calculator",
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { /* Handle click */ }
                        )
                        Spacer(modifier = Modifier.width(12.8.dp))

                        Image(
                            painter = painterResource(id = R.drawable.groupicon),
                            contentDescription = "Calculator",
                            modifier = Modifier
                                .width(21.33.dp)
                                .height(16.dp)
                                .clickable { /* Handle click */ }
                        )

                    }
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

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    {
                        CustomButton(
                            text = "Previous",
                            onClick = {},
                            buttonColor = Color(0xFFDAE9DB), // Green background
                            contentColor = Color(0xFF3D8543),// White text
                            buttonWidth = 146.dp, // Custom button width
                            buttonHeight = 28.dp, // Custom button height
                            textFontSize = 10,
                            elevation = 4.dp
                        )

                        Spacer(modifier=Modifier.weight(1f))
                        CustomButton(
                            text = "Continue",
                            onClick = {},
                            buttonColor = Color(0xFF3D8543), // Green background
                            contentColor = Color.White,// White text
                            buttonWidth = 146.dp, // Custom button width
                            buttonHeight = 28.dp, // Custom button height
                            textFontSize = 10,
                            elevation = 4.dp
                        )

                    }
                    Spacer(modifier = Modifier.height(34.dp))

                    Row(
                        modifier = Modifier
                            .height(139.dp)
                            .fillMaxWidth()// Consistent minimum width for tabs
                            .background(
                                color = Color(0xFFF8F8F8),
                                shape = RoundedCornerShape(10.dp) // Rounded corners
                            )
                            .border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(10.dp))
                            .padding(horizontal = 14.dp, vertical = 0.dp)
                    )
                    {

                        Column()
                        {
                            Row( modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth()// Consistent minimum width for tabs
                                .background(
                                    color = Color(0xFFF8F8F8),
                                    shape = RoundedCornerShape(0.dp) // Rounded corners
                                )
                                .padding(horizontal = 0.dp, vertical = 0.dp))
                            {
                                Text(
                                    text = "View solutions",
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 10.sp,
                                    color = Color.Black,
                                    fontFamily = PoppinsFontFamily,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically),
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .align(Alignment.CenterVertically),
                                    imageVector = Icons.Default.KeyboardArrowUp, // Usa un ícono de flecha predeterminado
                                    contentDescription = "Dropdown arrow",
                                    tint = Color.Black // Color gris para la flecha
                                )
                            }
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur .",
                                fontWeight = FontWeight.Medium,
                                fontSize = 9.1.sp,
                                color = Color(0xFF929292),
                                fontFamily = PoppinsFontFamily,
                                modifier = Modifier
                            )
                        }
                    }



                }

            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMode_2Screen() {
    GreenBridgeTheme {
        Mode_2Screen()
    }
}
