package com.example.currencyconversionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.screens.compare.CompareLayout
import com.example.currencyconversionapp.screens.convert.ConvertScreen
import com.example.currencyconversionapp.screens.favourite.FavouriteScreen
import com.example.currencyconversionapp.ui.theme.CurrencyConversionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConversionAppTheme {
                var convertScreen by remember {
                    mutableStateOf(true)
                }
                Column(modifier = Modifier) {


                    MainScreen(onConvertClick = { convertScreen = true },
                        onCompareClick = { convertScreen = false })
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1F)
                    ) {
                        if (convertScreen) {
                            ConvertScreen()
                        } else {
                           CompareLayout()
                        }
                    }
                }
        }
    }
}}

@Composable
fun MainScreen(onConvertClick: () -> Unit, onCompareClick: () -> Unit) {
//var _selectedItem=selectedItem

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(265.dp)
            .background(Color.White)

    ) {
        Image(
            painter = painterResource(id = R.drawable.top_image), modifier = Modifier

                .fillMaxWidth()
                .size(250.dp), contentDescription = "", contentScale = ContentScale.FillBounds
        )
        Column {
            Image(
                painter = painterResource(id = R.drawable.concurrency_text),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 16.dp, start = 8.dp)
                    .width(143.dp)
                    .height(32.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Currency Converter",
                    color = Color.White,
                    fontWeight = FontWeight(600),
                    fontSize = 24.sp,

                    )
                Text(
                    text = "check live foreign exchange rates",
                    color = Color.White,
                    fontWeight = FontWeight(400),
                    fontSize = 18.sp
                )
            }
        }
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White),
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                Text(
                    text = "Convert",
                    Modifier
                        .background(
                            color = Color.White,
                        )
                        .clip(shape = RoundedCornerShape(20.dp))
                        .padding(
                            9.dp
                        )
                        .clickable { onConvertClick() },
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight(400))
                )
                Text(

                    text = "Compare",
                    Modifier
                        .background(
                            color = Color.White,
                        )
                        .clip(shape = RoundedCornerShape(20.dp))
                        .padding(
                            9.dp
                        )
                        .clickable { onCompareClick() },
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight(400))
                )
            }
        }
    }
}
