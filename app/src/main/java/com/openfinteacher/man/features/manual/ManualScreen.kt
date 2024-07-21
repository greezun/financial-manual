package com.openfinteacher.man.features.manual

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.openfinteacher.man.R
import com.openfinteacher.man.data.models.manualsList

@Composable
fun ManualScreen(
    modifier: Modifier = Modifier,
    index: Int = 0,
    onBack: () -> Unit = {},
    onComplete: () -> Unit = {},
    onQuiz: (Int) -> Unit = {},
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var isResume by remember { mutableStateOf(false) }

    if (!isResume) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = manualsList[index][currentIndex]),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(10.dp),
                    onClick = {
                        if (currentIndex > 0) {
                            currentIndex--
                        } else {

                            onBack()
                        }
                    }
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.left_enable),
                        contentDescription = null
                    )
                }

                IconButton(
                    modifier = Modifier
                        .padding(10.dp),
                    onClick = {
                        if (currentIndex < manualsList[index].size - 1) {
                            currentIndex++
                        } else {
                            isResume = true
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.right_enable),
                        contentDescription = null
                    )
                }
            }
        }
    } else {
        ResumeScreen(
            onComplete = onComplete,
            onQuiz = { onQuiz(currentIndex) }
        )
    }
}


@Preview
@Composable
private fun Preview() {
    ManualScreen()
}