package com.groot.appshortcutsdemo

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.groot.appshortcutsdemo.ui.theme.AppShortcutsDemoTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //keep id same as it would create diff shortcut for different id
        val shortcut = ShortcutInfoCompat.Builder(applicationContext, "dynamic-shortcut")
            .setShortLabel("Website")
            .setLongLabel("Open the website")
            .setIcon(IconCompat.createWithResource(applicationContext, R.drawable.ic_launcher_foreground))
            .setIntent(
                Intent(Intent.ACTION_VIEW,
                Uri.parse("https://shraddhatongya97.medium.com/app-shortcuts-072da71c6f6e"))
            )
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(applicationContext, shortcut)

        setContent {
            AppShortcutsDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppShortcutsDemoTheme {
        Greeting("Android")
    }
}