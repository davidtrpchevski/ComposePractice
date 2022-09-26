package com.example.composepractice.ui.layouts.unit3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R
import java.text.NumberFormat

@Preview(showBackground = true)
@Composable
fun TipTimeCalculatorCustomTipApp() {
    TipTimeCalculatorCustomTip(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(32.dp)
    )
}

@Composable
fun TipTimeCalculatorCustomTip(modifier: Modifier = Modifier) {

    var amountInput by remember { mutableStateOf("") }
    val tipReturn = calculateTip(amountInput.toDoubleOrNull() ?: 0.0)

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberFieldCustomTip(amountInput) {
            amountInput = it
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.tip_amount, tipReturn),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CustomTipField(customTip: String, doOnTipChange: (String) -> Unit) {
    TextField(value = customTip, onValueChange = doOnTipChange)
}

@Composable
fun EditNumberFieldCustomTip(amountInput: String, doOnTextChange: (String) -> Unit) {
    TextField(
        value = amountInput,
        onValueChange = doOnTextChange,
        label = { Text(text = stringResource(id = R.string.cost_of_service)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0) =
    NumberFormat.getCurrencyInstance().format(tipPercent / 100 * amount)
