@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.replica.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replica.R

@Composable
fun HomeScreen(ynabScreen: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    val portfolioLink = "https://github.com/SnippyRex"

    Column(modifier = Modifier.fillMaxSize()) {
        ElevatedBar(title = {Text(text = stringResource(id = R.string.app_name), fontSize = 40.sp, fontWeight = FontWeight.SemiBold, color = Color(135, 187, 70, 255))})
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "A showcase of App Screen Recreations", fontWeight = FontWeight.Medium, textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(32.dp))
        Box(modifier = Modifier
            .padding(horizontal = 60.dp)
            .fillMaxWidth()) {
            Row(modifier = Modifier.align(alignment = Alignment.Center)) {
                TextButton(onClick = { ynabScreen() }, modifier = Modifier.background(
                    Color(135, 187, 70, 100)).fillMaxWidth(2f)) {
                    Text("YNAB - Move Money", fontSize = 20.sp)
                }
            }
        }
        Spacer(modifier = Modifier.size(200.dp))
        Box(modifier = Modifier
            .fillMaxWidth())  {
            Row(modifier = Modifier.align(Alignment.Center)){
                Icon(Icons.Filled.Share, contentDescription = "Link", tint = Color(135, 187, 70, 255), modifier = Modifier.align(alignment = CenterVertically) )
                TextButton(onClick = { uriHandler.openUri(portfolioLink) }) {
                    Text(text = "Creator Portfolio", textAlign = TextAlign.Center, fontSize = 16.sp)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedBar(title: @Composable ()-> Unit) {
    Surface(shadowElevation = 6.dp, modifier = Modifier.fillMaxWidth()) {
        CenterAlignedTopAppBar(title = title)
}}