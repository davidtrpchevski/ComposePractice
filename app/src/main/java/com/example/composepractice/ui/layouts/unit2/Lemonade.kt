package com.example.composepractice.ui.layouts.unit2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.composepractice.R

val lemonadeLit = listOf(
    LemonadeModel(R.string.lemonade_step_1, R.drawable.lemon_tree),
    LemonadeModel(R.string.lemonade_step_2, R.drawable.lemon_squeeze),
    LemonadeModel(R.string.lemonade_step_3, R.drawable.lemon_drink),
    LemonadeModel(R.string.lemonade_step_4, R.drawable.lemon_restart)
)

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Lemonade(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {

    var lemonadeStep by remember { mutableStateOf(0) }
    val squeezeTimes = generateSqueezeNumber()
    var times by remember { mutableStateOf(0) }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = lemonadeLit[lemonadeStep].stepDescription),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                when (lemonadeStep) {
                    in 0..3 -> {
                        if (lemonadeStep == 1 && times != squeezeTimes) {
                            times += 1
                        } else
                            lemonadeStep += 1
                    }
                    else -> lemonadeStep = 0
                }

//                if (lemonadeStep < 3) {
//                    if (lemonadeStep == 1 && times != squeezeTimes) {
//                        times += 1
//                    } else
//                        lemonadeStep += 1
//                } else lemonadeStep = 0
            },
            border = BorderStroke(1.dp, Color.Cyan),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = lemonadeLit[lemonadeStep].stepImage),
                contentDescription = null
            )
        }
    }
}

fun generateSqueezeNumber(): Int = (2..4).random()