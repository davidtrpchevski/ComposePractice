package com.david.composepractice.ui.layouts.unit2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.composepractice.R

@Preview(showBackground = true)
@Composable
fun LemonadeCodeLabApp() {
    LemonadeCodeLab(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeCodeLab(modifier: Modifier = Modifier) {
    var lemonadeStep by remember { mutableStateOf(1) }
    var squeezeTimes by remember { mutableStateOf(0) }
    Surface(modifier = modifier, color = MaterialTheme.colors.background) {
        when (lemonadeStep) {
            1 -> LemonadeStep(R.string.lemonade_step_1, R.drawable.lemon_tree) {
                squeezeTimes = generateNumber(2, 4)
                lemonadeStep += 1
            }
            2 -> LemonadeStep(R.string.lemonade_step_2, R.drawable.lemon_squeeze) {
                if (squeezeTimes != 0) squeezeTimes-- else lemonadeStep += 1
            }
            3 -> LemonadeStep(R.string.lemonade_step_3, R.drawable.lemon_drink) {
                lemonadeStep += 1
            }
            4 -> LemonadeStep(R.string.lemonade_step_4, R.drawable.lemon_restart) {
                lemonadeStep += 1
            }
            else -> lemonadeStep = 1
        }
    }
}

@Composable
fun LemonadeStep(lemonadeStepText: Int, lemonadeStepImage: Int, doOnImageClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = lemonadeStepText), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = lemonadeStepImage),
            contentDescription = null,
            modifier = Modifier
                .border(BorderStroke(2.dp, Color.Cyan), shape = RoundedCornerShape(4.dp))
                .clickable(enabled = true, onClick = doOnImageClick)
                .padding(16.dp)
        )
    }
}