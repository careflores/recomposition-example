package com.example.recomposition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

// Flat hierarchy
private var levelFlatten1 = 0
private var levelFlatten2 = 0
private var levelFlatten3 = 0
private var levelFlatten4 = 0

@Composable
fun FlattenHierarchy() {
    var isOn1 by remember { mutableStateOf(0) }
    var isOn2 by remember { mutableStateOf(0) }
    var isOn3 by remember { mutableStateOf(0) }
    var isOn4 by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth()) {
        FlattenHierarchy1(isOn1) { isOn1++ }
        FlattenHierarchy2(isOn2) { isOn2++ }
        FlattenHierarchy3(isOn3) { isOn3++ }
        FlattenHierarchy4(isOn4) { isOn4++ }
    }
}


@Composable
fun FlattenHierarchy1(isOn1: Int, onClick: () -> Unit) {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            onClick = onClick
        ) {
            levelFlatten1++
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray),
                text = "Recompositions: $levelFlatten1; Clicks: $isOn1",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun FlattenHierarchy2(isOn2: Int, onClick: () -> Unit) {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            onClick = onClick
        ) {
            levelFlatten2++
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Magenta),
                text = "Recompositions: $levelFlatten2; Clicks: $isOn2",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun FlattenHierarchy3(isOn3: Int, onClick: () -> Unit) {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
            onClick = onClick
        ) {
            levelFlatten3++
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Yellow),
                text = "Recompositions: $levelFlatten3; Clicks: $isOn3",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun FlattenHierarchy4(isOn4: Int, onClick: () -> Unit) {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            onClick = onClick
        ) {
            levelFlatten4++
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Green),
                text = "Recompositions: $levelFlatten4; Clicks: $isOn4",
                textAlign = TextAlign.Center
            )
        }
    }
}
