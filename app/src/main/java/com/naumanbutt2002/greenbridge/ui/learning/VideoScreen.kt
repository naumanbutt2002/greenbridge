import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.naumanbutt2002.greenbridge.ui.theme.GreenBridgeTheme
import com.naumanbutt2002.greenbridge.ui.theme.PoppinsFontFamily
import com.naumanbutt2002.greenbridge.ui.timetable.commponents.TopRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        // Top Row: Back Button
        TopRow(
            title = "Basic Concept",
            onBackClick = { /* Handle back button click */ },
        )
        TopTabRowV()

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 13.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {

            // Video Player

            VideoPlayerScreen(videoUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1")
            Spacer(modifier = Modifier.height(13.dp))

            Column (
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 23.dp, horizontal = 14.dp)
                )
                {
                    // Audio Player
                    AudioPlayerList()

                }

            }

        }

    }
}

@Composable
fun VideoPlayerScreen(videoUrl: String) {
    val context = LocalContext.current
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }
    DisposableEffect(
        key1 = exoPlayer,
        effect = {
            exoPlayer.setMediaItem(MediaItem.fromUri(videoUrl))
            exoPlayer.prepare()
            exoPlayer.playWhenReady = false
            onDispose { exoPlayer.release() }
        }
    )

    AndroidView(
        factory = { PlayerView(context).apply { player = exoPlayer } },
        modifier = Modifier
            .fillMaxWidth()
            .height(205.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}

data class AudioItem(
    val title: String,
    val duration: String,
    val isFree: Boolean,
    val audioUrl: String
)

@Composable
fun AudioPlayerList() {
    val audioItems = listOf(
        AudioItem("Basic concept I", "20 Minutes", true, "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"),
        AudioItem("Basic concept II", "20 Minutes", false, "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3"),
        AudioItem("Introduction to Agric", "20 Minutes", true, "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        Text(
            text = "Other videos",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.scrim,
            lineHeight = 18.sp,
            fontFamily = PoppinsFontFamily,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        audioItems.forEach { audioItem ->
            AudioPlayerItem(audioItem)
        }
    }
}

@Composable
fun AudioPlayerItem(audioItem: AudioItem) {
    var isPlaying by remember { mutableStateOf(false) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 7.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = audioItem.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.scrim,
                    )
                    if (audioItem.isFree) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(15.dp)
                                .width(35.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.inversePrimary,
                                    shape = CircleShape
                                )
                        ) {
                            Text(
                                text = "Free",
                                fontSize = 8.sp,
                                color = MaterialTheme.colorScheme.scrim,
                                fontWeight = FontWeight.Medium,
                                fontFamily = PoppinsFontFamily,
                                modifier = Modifier.offset(y= (-4).dp)
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = "Duration",
                        modifier = Modifier.size(9.dp),
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                    Text(
                        text = audioItem.duration,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(28.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceDim,
                        shape = CircleShape
                    )
            )
            {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying) "Pause" else "Play",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            if (isPlaying) {
                                mediaPlayer?.pause()
                                isPlaying = false
                            } else {
                                mediaPlayer?.release()
                                mediaPlayer = MediaPlayer().apply {
                                    setDataSource(audioItem.audioUrl)
                                    prepare()
                                    start()
                                }
                                isPlaying = true
                            }
                        },
                    tint = MaterialTheme.colorScheme.scrim
                )
            }

        }

    }
}


@Composable
fun TopTabRowV() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 18.5.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Spacing between tabs
    ) {
        TabItemL("Overview", isSelected = false)
        TabItemL("Videos", isSelected = true)
        TabItemL("Lesson Plans", isSelected = false)
        TabItemL("Recommended Books", isSelected = false)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVideoScreen() {
    GreenBridgeTheme {
        VideoScreen()
    }
}
