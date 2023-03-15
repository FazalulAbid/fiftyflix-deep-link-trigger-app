package com.fifty.fiftyflixdeeplinktrigger

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fifty.fiftyflixdeeplinktrigger.ui.theme.FiftyFlixDeepLinkTriggerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiftyFlixDeepLinkTriggerTheme {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Button(onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://abid-coding.com/505642")
                        )
                        val pendingIntent = TaskStackBuilder.create(applicationContext).run {
                            addNextIntentWithParentStack(intent)
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                getPendingIntent(
                                    0,
                                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                                )
                            } else {
                                getPendingIntent(
                                    0,
                                    PendingIntent.FLAG_UPDATE_CURRENT
                                )
                            }
                        }
                        pendingIntent.send()
                    }) {
                        Text(text = "Trigger deeplink")
                    }
                }
            }
        }
    }
}