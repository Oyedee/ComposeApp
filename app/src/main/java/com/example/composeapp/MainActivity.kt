package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.Typography
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        CustomText(name = "Hamid O.")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .width(100.dp)
                .height(100.dp)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "This is a Box using jetpack compose", fontSize = 40.sp)
        }
    }

}


@Composable
fun CustomText(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(10.dp)
            .width(200.dp),
        color = Color.Magenta,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CustomText2() {
    Text(
        buildAnnotatedString {
            withStyle(ParagraphStyle(textAlign = TextAlign.Center)){
                withStyle(style = SpanStyle(
                    color = Color.Red, fontSize = 100.sp, shadow = Shadow(color = Color.Gray),
                    fontWeight = FontWeight.ExtraBold
                )){
                    append("H")
                }
                append("A")
                append("M")
                append("I")
                append("D")
            }
        },
    fontSize = 30.sp,
    modifier = Modifier.width(200.dp).background(color = Color.Cyan).padding(16.dp),
    fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun CustomTemplate() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CustomText(name = "Hamid O.")
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(2f),
            color = MaterialTheme.colors.primary
        ) {

        }

        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(3f),
            color = MaterialTheme.colors.primaryVariant
        ) {
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            CustomText(name = "Using rows explicitly")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomText(name = "Compose Text")
            CustomText2()
        }
    }
}
