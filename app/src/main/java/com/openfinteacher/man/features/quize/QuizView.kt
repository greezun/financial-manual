package com.openfinteacher.man.features.quize

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openfinteacher.man.R
import com.openfinteacher.man.data.models.manualsList
import com.openfinteacher.man.data.models.quizQuestionsList
import com.openfinteacher.man.data.models.quiz_1

@Composable
fun QuizView(
    modifier: Modifier = Modifier,
    index: Int = 0,
    onComplete:() ->Unit = {},
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var currentButton by remember { mutableIntStateOf(-1) }

    var answerList by remember {
        mutableStateOf<List<Int>>(emptyList())
    }

    var toResult by remember {
        mutableStateOf(false)
    }

    if(!toResult) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.8f)
                ) {
                    IconButton(
                        onClick = onComplete) {
                        Icon(
                            modifier = Modifier.size(100.dp),
                            imageVector = Icons.Outlined.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }

                    Text(
                        text = quizQuestionsList[index][currentIndex].question.uppercase(),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )

                    Image(
                        painter = painterResource(id = quizQuestionsList[index][currentIndex].image),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    quizQuestionsList[index][currentIndex].answerList.forEachIndexed { index, question ->
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { currentButton = index }
                        ) {
                            Image(
                                painter = painterResource(id = if (currentButton >= 0 && currentButton == index) R.drawable.blue_bt else R.drawable.white_bt),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp)
                                    .align(Alignment.CenterStart),
                                text = question,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Medium
                            )


                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(0.15f)
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            enabled = (currentButton >= 0)
                        ) {
                            if (currentButton == quizQuestionsList[index][currentIndex].rightAnswer) {
                                Log.d("appTAG", "QuizView: right")
                                answerList = answerList + currentButton
                            }
                            if (currentIndex < quizQuestionsList[index].size - 1) {
                                currentIndex++
                                currentButton = -1
                            } else {
                                toResult = true
                            }
                            Log.d("appTAG", "QuizView: $answerList")
                        }
                    ) {
                        Image(
                            painter = painterResource(id = if (currentButton >= 0) R.drawable.blue_bt else R.drawable.gray_bt),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center),
                            text = "Продолжить",
                            fontSize = 24.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    } else{

        QuizResultScreen(
            modifier = modifier,
            questIndex = index,
            resultIndex = if(answerList.size == 6) 0 else 1
        ) {
            onComplete()
        }

    }
}

@Preview
@Composable
private fun Preview() {
    QuizView()
}