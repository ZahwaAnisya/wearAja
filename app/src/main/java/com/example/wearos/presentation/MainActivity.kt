package com.example.wearos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.wearos.R
import com.example.wearos.presentation.theme.WearOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            WearApp("Android")
        }
    }
}

@Composable
fun WearApp(greetingName: String) {
    WearOSTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(10.dp) // Padding agar tidak terlalu dekat dengan tepi
        ) {
            // TimeText tetap di atas
            TimeText(
                modifier = Modifier.align(Alignment.TopCenter)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp), // Jaga jarak dari tepi layar
                verticalArrangement = Arrangement.Top, // Elemen diatur dari atas ke bawah
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Row untuk ikon heart rate dan lokasi (sejajar)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    // Ikon Heart Rate
                    Image(
                        painter = painterResource(id = R.drawable.heart_rate),
                        contentDescription = "Heart Rate Icon",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp) // Beri jarak dengan ikon location
                    )

                    // Ikon Location
                    LocationIcon()
                }

                Spacer(modifier = Modifier.weight(1f)) // Memberi ruang agar teks greeting tetap di tengah

                // Teks Greeting di tengah layar
                Greeting(
                    greetingName = greetingName,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun LocationIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_location), // Menggunakan Vector Asset
        contentDescription = "Location",
        tint = MaterialTheme.colors.primary,
        modifier = Modifier
            .size(24.dp)
    )
}

@Composable
fun Greeting(greetingName: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = "Welcome to Wear OS, $greetingName!"
    )
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}
