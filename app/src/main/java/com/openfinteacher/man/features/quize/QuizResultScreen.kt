package com.openfinteacher.man.features.quize


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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.openfinteacher.man.data.models.quizResultsList
import com.openfinteacher.man.data.models.quiz_1_result

@Composable
fun QuizResultScreen(
    modifier: Modifier = Modifier,
    questIndex:Int = 2,
    resultIndex: Int = 0,
    onComplete:()->Unit = {}
) {
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

                Spacer(modifier = Modifier.height(60.dp))

                Image(
                    painter = painterResource(id = quiz_1_result[resultIndex].image),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(24.dp))

                if(quizResultsList[questIndex][resultIndex].isRight) {
                    Text(
                        text = "поздравляем!".uppercase(),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                val scrollState = rememberScrollState()
                Column ( Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(bottom = 8.dp),
                ){
                    Text(
                        text = quizResultsList[questIndex][resultIndex].resume,
                        modifier = Modifier
                            .fillMaxWidth(),

                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.15f)
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onComplete()
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.blue_bt),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center),
                        text = "Завершить",
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    QuizResultScreen()
}