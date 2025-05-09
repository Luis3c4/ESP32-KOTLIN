package com.example.proyectoESP32
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ESP32ControlTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ESP32ControlApp()
                }
            }
        }
    }
}

@Composable
fun ESP32ControlTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = Color.White,
            surface = Color.White,
            onSurface = Color.Black,
            primary = Color.Black,
            onPrimary = Color.White
        ),
        content = content
    )
}

@Composable
fun ESP32ControlApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Smartphone frame
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                // Header
                Header()

                // Main content
                MainContent()
            }
        }
    }
}


@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ESP32 Control",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }

    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Voice control button
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CONTROL POR VOZ",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Microphone icon
        Box(
            modifier = Modifier
                .size(120.dp)
                .border(2.dp, Color.Black, CircleShape)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_mic),
                contentDescription = "Microphone",
                modifier = Modifier.size(68.dp),
                tint = Color.Black
            )
        }

        // ON/OFF buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { /* TODO: Turn ON */ },
                modifier = Modifier
                    .width(180.dp)
                    .height(100.dp),
                shape = RoundedCornerShape(8.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "ON",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            OutlinedButton(
                onClick = { /* TODO: Turn OFF */ },
                modifier = Modifier
                    .width(180.dp)
                    .height(100.dp),
                shape = RoundedCornerShape(8.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "OFF",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        // Control buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Fan button
            ControlButton(
                icon = R.drawable.ic_fan,
                label = "VENTILADOR",
                onClick = { /* TODO: Control fan */ }
            )

            // Lock button
            ControlButton(
                icon = R.drawable.ic_lock,
                label = "CERRADURA",
                onClick = { /* TODO: Control lock */ }
            )

            // Light button
            ControlButton(
                icon = R.drawable.ic_light,
                label = "LUZ",
                onClick = { /* TODO: Contr
                ol light */ }
            )
        }
    }
}

@Composable
fun ControlButton(icon: Int, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier.size(80.dp),
            shape = RoundedCornerShape(8.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
            contentPadding = PaddingValues(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black
            )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ESP32ControlTheme {
        ESP32ControlApp()
    }
}
