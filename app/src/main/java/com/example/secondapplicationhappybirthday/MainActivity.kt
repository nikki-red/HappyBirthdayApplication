package com.example.secondapplicationhappybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.secondapplicationhappybirthday.ui.theme.SecondApplicationHappyBirthdayTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondApplicationHappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(getString(R.string.happy_birthday_name), getString(R.string.signature_name))
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, from: String, modifier: Modifier = Modifier) {
    // Modifier elements need to be passed to child elements of composable
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier) {
        Text(
            text = "Happy Birthday $name!",
            fontSize = 50.sp,
            lineHeight = 55.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "from $from",
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}
@Composable
fun GreetingImage(name: String, from: String, modifier: Modifier = Modifier) {
    // painterResource loads a drawable image resource and take ID as argument
    // "R.drawable.androidparty" is the ID
    // Resources can be accessed with resource IDs that are generated in R class
    // R class is an automatically generated class by Android that contains the IDs
    val image = painterResource(R.drawable.androidparty)
    // Box composable to overlap image and text
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            name = name,
            from = from,
            modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview"
)
@Composable
fun BirthdayCardPreview() {
    SecondApplicationHappyBirthdayTheme {
         GreetingImage(
             name = stringResource(R.string.happy_birthday_name),
             from = stringResource(R.string.signature_name)
         )
        //GreetingText(name = "Naina", from = "Susan")
    }
}