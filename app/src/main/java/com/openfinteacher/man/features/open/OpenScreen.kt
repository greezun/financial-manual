package com.openfinteacher.man.features.open

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.openfinteacher.man.R
import kotlinx.coroutines.delay

@Composable
fun OpenScreen(
    modifier: Modifier = Modifier,
    next:()->Unit = {}
) {
    Box(modifier = modifier
        .fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.open),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }

    LaunchedEffect (Unit) {
        delay(500)
        next()
    }

}

@Preview
@Composable
private fun Preview() {
    OpenScreen()
}