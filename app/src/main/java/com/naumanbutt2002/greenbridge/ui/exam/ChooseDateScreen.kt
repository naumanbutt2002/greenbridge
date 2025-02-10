package com.naumanbutt2002.greenbridge.ui.exam
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naumanbutt2002.greenbridge.R
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseDateScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f)) // Full Screen Background
    ) {
        // Full Screen Timetable Screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(0.5.dp)

        ) {
            ExamsScreen() // This takes the entire screen as a background
        }

        ChooseDateDialog()

    }
}
@Composable
fun ChooseDateDialog() {
    // Estado para controlar la visibilidad del diálogo
    var showDialog by remember { mutableStateOf(true) }

    // Datos dinámicos: Lista de años y si cada uno es premium
    val examYears = listOf(
        Pair("1990", true),
        Pair("1991", false),
        Pair("1992", true),
        Pair("1993", false),
        Pair("1994", true),
        Pair("1995", true),
        Pair("1996", false),
        Pair("1997", false),
        Pair("1998", false),
        Pair("1999", false),
        Pair("2000", false),
        Pair("2001", false),
        Pair("2002", true),
        Pair("2001", false),

    )

    if (showDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000)) // Fondo semi-transparente
        ) {
            Box(
                modifier = Modifier
                    .width(393.dp) // Ancho del diálogo
                    .height(636.dp) // Altura del diálogo
                    .offset(y = (0.25f * LocalConfiguration.current.screenHeightDp).dp)
                    .align(Alignment.TopCenter)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp, top = 39.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Choose exam year",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.scrim,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = R.drawable.x),
                            contentDescription = "Close",
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { showDialog = false } // Cerrar el diálogo
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                    // Lista de años con botones premium
                    examYears.forEach { (year, isPremium) ->
                        ExamYearRow(year = year, isPremium = isPremium)
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.tertiaryContainer)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExamYearRow(year: String, isPremium: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = year,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.scrim,
            modifier = Modifier.padding(top=10.dp, bottom = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isPremium) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(59.dp)
                    .height(20.dp)
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(5.dp))
            ) {
                Text(
                    text = "Premium",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.offset(y = (-2).dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChooseDateScreen() {
    GreenBridgeTheme {
        ChooseDateScreen()
    }
}
