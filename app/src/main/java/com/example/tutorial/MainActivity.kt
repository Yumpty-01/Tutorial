package com.example.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial.ui.theme.SampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    GreetingImage(message = getString(R.string.happy_birthday_madhu), from = getString(
                        R.string.signature_text
                    ), modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun GreetingText(message:String,from:String,modifier:Modifier=Modifier){
    Column(modifier=modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier= Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message:String,from:String,modifier: Modifier=Modifier){
    val image= painterResource(R.drawable.androidparty)
    Box(modifier ){
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha=0.5F,
            )
    }
    GreetingText(message , from ,modifier= Modifier
        .fillMaxSize()
        .padding(8.dp))
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun Greet() {
    SampleTheme {
        GreetingImage(message = "Happy Birthday James", from = "Sam")
    }
}