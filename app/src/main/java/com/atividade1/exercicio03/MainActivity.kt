package com.atividade1.exercicio03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atividade1.exercicio03.ui.theme.Exercicio03Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercicio03Theme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Row(Modifier.weight(1f)) {
                CategoryItem("Woman", Icons.Default.Person, Color(0xFF9FB9B9), Modifier.weight(1f))
                CategoryItem("Man", Icons.Default.Person, Color(0xFF88A6A6), Modifier.weight(1f))
            }

            Row(Modifier.weight(1f)) {
                CategoryItem("Baby", Icons.Default.Face, Color(0xFF5C7D7D), Modifier.weight(1f))
                CategoryItem("Travel", Icons.Default.Home, Color(0xFF4F6D6D), Modifier.weight(1f))
            }

            Row(Modifier.weight(1f)) {
                CategoryItem("Tech", Icons.Default.Settings, Color(0xFF3E5C5C), Modifier.weight(1f))
                CategoryItem("Food&Drink", Icons.Default.ShoppingCart, Color(0xFF345050), Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun CategoryItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                color = Color.White
            )
        }
    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.categories))
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary)
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Exercicio03Theme {
        MyApp()
    }
}