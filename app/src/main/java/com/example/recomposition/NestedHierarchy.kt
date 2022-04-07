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

// Nested hierarchy

private var levelNested1 = 0
private var levelNested2 = 0
private var levelNested3 = 0
private var levelNested4 = 0

@Composable
fun NestedHierarchy() {
    var isOnBad11 by remember { mutableStateOf(0) }
    var isOnBad12 by remember { mutableStateOf(0) }
    var isOnBad13 by remember { mutableStateOf(0) }
    var isOnBad14 by remember { mutableStateOf(0) }

    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
        onClick = { isOnBad11++ }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            levelNested1++
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Recompositions: $levelNested1; Clicks: $isOnBad11",
                textAlign = TextAlign.Center
            )
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
                onClick = { isOnBad12++ }
            ) {
                levelNested2++
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Magenta),
                        text = "Recompositions: $levelNested2; Clicks: $isOnBad12",
                        textAlign = TextAlign.Center
                    )
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                        onClick = { isOnBad13++ }
                    ) {
                        levelNested3++
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.Yellow),
                                text = "Recompositions: $levelNested3; Clicks: $isOnBad13",
                                textAlign = TextAlign.Center
                            )
                            Button(
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                                onClick = { isOnBad14++ }
                            ) {
                                levelNested4++
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = Color.Green),
                                    text = "Recompositions: $levelNested4; Clicks: $isOnBad14",
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
