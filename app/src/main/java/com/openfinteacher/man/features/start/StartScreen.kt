package com.openfinteacher.man.features.start

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onManual: (Int) -> Unit = {},
    onQuiz: (Int) -> Unit = {},
) {

    var quizStatus by remember {
        mutableStateOf(false)
    }

    val choiceState = !quizStatus



    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.start_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                when {
                    quizStatus -> QuizPrev {
                        Log.d("appTAG", "StartScreen: QuizPrev index $it ")
                        onQuiz(it) }
                    choiceState -> ManualPrev { onManual(it) }
                }
            }

            Row(
                modifier = Modifier

                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    modifier = Modifier
                        .size(100.dp),
                    onClick = {
                        quizStatus = true
                    }
                ) {

                    Image(
                        painter = painterResource(id = if (quizStatus) R.drawable.quiz_enable else R.drawable.quiz_disable),
                        contentDescription = null
                    )
                }

                IconButton(
                    modifier = Modifier
                        .size(100.dp),
                    onClick = {
                        quizStatus = false
                    }
                ) {
                    Image(
                        modifier = Modifier,

                        painter = painterResource(id = if (choiceState) R.drawable.choice_enable else R.drawable.choice_disable),
                        contentDescription = null
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun Preview() {
    StartScreen()
}