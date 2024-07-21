package com.openfinteacher.man.features.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openfinteacher.man.data.models.manualPrevList
import com.openfinteacher.man.data.models.quizPrevList

@Composable
fun QuizPrev(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {}

) {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            text = "ПРОВЕРТЕ СВОИ ЗНАНИЯ:\nКвизы по Финансовой\n" +
                    "Грамотности",
            fontSize = 28.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

        ) {
            itemsIndexed(quizPrevList) { index, item ->
                Image(
                    modifier = Modifier.clickable { onClick(index) },
                    painter = painterResource(id = item), contentDescription = null
                )
                Spacer(modifier = Modifier.height(16.dp))
            }


        }
    }


}

@Preview
@Composable
private fun Preview() {
    QuizPrev()
}