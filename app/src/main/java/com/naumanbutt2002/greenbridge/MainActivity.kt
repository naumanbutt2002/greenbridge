package com.naumanbutt2002.greenbridge

import LearningScreen
import LessonNotes
import OverviewScreen
import PastQuestions
import RecommendedBooks
import SearchResults
import Topics_1Screen
import VideoScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.naumanbutt2002.greenbridge.ui.accountsetup.NameScreen
import com.naumanbutt2002.greenbridge.ui.home.HomePageScreen
import com.naumanbutt2002.greenbridge.ui.home.SearchScreen
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import java.util.jar.Attributes.Name

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenBridgeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .windowInsetsPadding(WindowInsets.statusBars) // Add padding for the status bar
                ) {
                    VideoScreen()
                }
            }
        }
    }
    private fun enableEdgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreenBridgeTheme {

    }
}