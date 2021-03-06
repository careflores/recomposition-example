package com.example.recomposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recomposition.ui.theme.RecompositionTheme

class MainActivity : ComponentActivity() {

    val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecompositionTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                ) {
                    Text(text = "Flatten hierarchy")
                    FlattenHierarchy()
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Nested hierarchy")
                    NestedHierarchy()
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "UI State")
                    UIState(vm)
                }
            }
        }
    }
}

