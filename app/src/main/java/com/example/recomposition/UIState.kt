package com.example.recomposition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

private var levelColumn = 0
private var levelRow = 0

@Composable
fun UIState(viewModel: MainViewModel) {
    val state: MainState by viewModel.state.collectAsState()
    MainScaffold(
        state,
        onValueUpdate = { viewModel.updateSlider(it.roundToInt()) },
        onButtonClick = viewModel::updateCounter
    )
}

@Composable
fun MainScaffold(state: MainState, onValueUpdate: (Float) -> Unit, onButtonClick: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            levelColumn++
            Text(text = "Recompositions column: $levelColumn")
            Slider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                value = state.sliderValue.toFloat(),
                onValueChange = onValueUpdate,
                valueRange = 0f..10f,
                steps = 10
            )
            CounterRow(counter = state.counter, onButtonClick = onButtonClick)
        }
    }
}

@Composable
fun CounterRow(counter: Int, onButtonClick: () -> Unit) {
    /** SHOULD NOT BE CALLED ON SLIDER CHANGE **/
    Row(modifier = Modifier.fillMaxWidth()) {
        levelRow++
        Text(text = "Recompositions row: $levelRow")
        Spacer(modifier = Modifier.width(24.dp))
        Button(onClick = onButtonClick) {
            Text(text = "Click me!")
        }
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = "Clicks: $counter")
    }
}