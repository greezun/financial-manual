package com.openfinteacher.man.features.manual

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openfinteacher.man.R


@Composable
fun ResumeScreen(
    modifier: Modifier = Modifier,
    onComplete:() ->Unit = {},
    onQuiz:() ->Unit = {},

) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.rezume_back),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column (modifier = Modifier.fillMaxSize()){
            Text(
                modifier = Modifier
                    .padding(top = 96.dp)
                    .padding(horizontal = 34.dp)
                ,
                text = stringResource(id = R.string.manual_1),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp)
                .clickable { onQuiz() }
            ){
                Image(painter = painterResource(id = R.drawable.blue_bt), contentDescription = null)
                Text(modifier = Modifier
                    .align(Alignment.Center),
                    text = "Пройти тест",
                    fontSize = 24.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp)
                .clickable { onComplete() }
            ){
                Image(painter = painterResource(id = R.drawable.white_bt), contentDescription = null)
                Text(modifier = Modifier
                    .align(Alignment.Center),
                    text = "Завершить",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview() {
    ResumeScreen()
}