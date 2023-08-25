package com.example.currencyconversionapp.screens.favourite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R


@Composable
fun FavouriteScreen() {

MyDialogUIPreview()

}

val currenciesList = listOf<Currencies>(
    Currencies(R.drawable.united_states_of_america, "USD", "American Dollars"),
    Currencies(R.drawable.united_kingdom, "GBP", "Pound Sterling"),
    Currencies(R.drawable.japan, "JPY", "Japanese Yen"),
    Currencies(R.drawable.united_states_of_america, "USD", "American Dollars"),
    Currencies(R.drawable.united_kingdom, "GBP", "Pound Sterling"),
    Currencies(R.drawable.japan, "JPY", "Japanese Yen")
)



/**
 * LAYOUT FOR DISPLAYING CURRENCIES
 * CALLS DISPLAY CURRENCIES METHOD INSIDE LAZY COLUMN
 *
 * */
    @Composable
    fun FavouriteLayout() {

        Column(
            modifier = Modifier
                .size(0.dp)
                .padding(30.dp)
                .wrapContentSize(Alignment.Center)
                .background(color = Color(0xFFF8F8F8), shape = RoundedCornerShape(size = 20.dp)),

        ) {

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    modifier = Modifier.padding(5.dp),
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "image description",


                    )
            }


            Surface(shape = RoundedCornerShape(30.dp)) {


//                val currenciesList = listOf<Currencies>(
//                    Currencies(R.drawable.united_states_of_america, "USD", "American Dollars"),
//                    Currencies(R.drawable.united_kingdom, "GBP", "Pound Sterling"),
//                    Currencies(R.drawable.japan, "JPY", "Japanese Yen"),
//                    Currencies(R.drawable.united_states_of_america, "USD", "American Dollars"),
//                    Currencies(R.drawable.united_kingdom, "GBP", "Pound Sterling"),
//                    Currencies(R.drawable.japan, "JPY", "Japanese Yen")
//                )



                Column {

                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "My Favorites",
                            style = TextStyle(
                                fontSize = 17.34.sp,
                                lineHeight = 23.12.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF121212),
                            ),
                            modifier = Modifier
                                .width(200.dp)
                                .height(24.dp)
                        )


                        LazyColumn(
                            modifier = Modifier
                                .width(315.dp)
                                .height(492.16513.dp),
                            verticalArrangement = Arrangement.spacedBy(
                                15.41284465789795.dp,
                                Alignment.Top
                            ),
                            horizontalAlignment = Alignment.Start,
                            contentPadding = PaddingValues(13.dp),
                        ) {

                            /**
                             * CALLING DISPLAY CURRENCIES FUNCTION TO DISPLAY EACH CURRENCY OBJECT IN LIST IN
                             * A LAZY COLUMN
                             * */
                            items(currenciesList) {

                                DisplayCurrencies(
                                    currency = Currencies(
                                        image = it.image,
                                        id = it.id,
                                        title = it.title
                                    )
                                )

                                Spacer(modifier = Modifier.height(12.dp))
                                Divider(
                                    modifier = Modifier
                                        .width(315.dp)
                                        .height(0.9633.dp)
                                        .background(color = Color(0xFFB9C1D9))
                                )
                            }
                        }


                    }
                }
            }
        }


    }

/**
 *
 * DISPLAYS CURRENCY OBJECT ON SCREEN
 *
 *
 *
 *
 * */

    @Composable
    fun DisplayCurrencies(currency: Currencies) {

        Row {
            Image(
                painter = painterResource(currency.image),
                contentDescription = "User profile pic",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.padding(),

                ) {

                Text(
                    modifier = Modifier
                        .width(31.dp)
                        .height(24.dp),
                    text = currency.id, style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF121212),
                    )
                )


                Spacer(modifier = Modifier.height(2.dp))


                Text(
                    text = currency.title, style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 19.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFB8B8B8),
                    )
                )


            }
            var selected by remember {
                mutableStateOf(false)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            )
            {
                RoundedCheckbox(selected = selected, onChecked = {

                    if (selected ) {
                        selected = false
                    } else {
                        selected = true
                    }
                })
            }


        }


    }












data class Currencies(
    var image: Int,
    var id: String,
    var title:String,

    )





























