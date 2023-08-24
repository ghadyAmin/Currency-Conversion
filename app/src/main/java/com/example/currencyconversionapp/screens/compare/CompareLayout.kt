package com.example.currencyconversionapp.screens.compare

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.currencyconversionapp.R


@Preview(showBackground = true, device = Devices.PIXEL_4, name = "Phone")
@Preview(showBackground = true, device = Devices.NEXUS_7, name = "Tablet")
@Preview(showBackground = true, device = Devices.PIXEL_C, name = "Large Tablet")
@Composable
fun CompareLayout(){
TopImageWithText()
    CompareBox()
    //LastBox()
   // MyDialogUIPreview()

}

/**
* TOP IMAGE WITH TEXT FUNCTION CONTAINS BACKGROUND IMAGE AND ALL ELEMENTS ON TOP OF IT
* */
@Composable
fun TopImageWithText(
    modifier: Modifier = Modifier

){


    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(239.dp)

    ) {


        Image(
            painter = painterResource(id = R.drawable.top_image),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(239.dp)
        )


        Image(
            painter = painterResource(id = R.drawable.concurrency_text),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
                .padding(5.dp)


        )



            Text(

                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomCenter),

                text = "Currency Converter",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),

                )


            )


        Text(
            modifier= Modifier
                .height(180.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.BottomCenter),

            text = "Check live foreign currency exchange rates",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
            )
        )



        CustomSwitch( )




        }


    }
/**COMPARE BOX FUNCTION CONTAINS AMOUNT AND FROM TEXT, TEXT FIELD FOR AMOUNT, DROPDOWN MENU
AND TARGET CURRENCY TEXT
* */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CompareBox(){


    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
       ) {


       Column (modifier = Modifier
           .fillMaxSize()
           .width(100.dp)){

         Row  {
               Text(
                   modifier = Modifier
                       .height(340.dp)
                       .width(200.dp)
                       .padding(25.dp)
                       .wrapContentSize(Alignment.BottomStart),
                   text = "Amount",
                   style = TextStyle(
                       fontSize = 20.sp,
                       fontFamily = FontFamily.Monospace,
                       fontWeight = FontWeight(600),
                       color = Color(0xFF000000),
                   )
               )
             Spacer(modifier = Modifier.width(1.dp))

             Text(
                 modifier = Modifier
                     // .fillMaxWidth()
                     .height(340.dp)
                     //  .width(200.dp)
                     .padding(horizontal = 5.dp, vertical = 25.dp)
                     .wrapContentSize(Alignment.BottomEnd),
                 text = "From",
                 style = TextStyle(
                     fontSize = 20.sp,
                     fontFamily = FontFamily.Monospace,
                     fontWeight = FontWeight(600),
                     color = Color(0xFF000000),
                 )
             )




           }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 0.dp)) {
             TextField(
                 value = "hello", onValueChange = {},
                 colors = TextFieldDefaults.textFieldColors(
                     containerColor = Color(0xFFF9F9F9),
                     focusedIndicatorColor = Color.Transparent,
                     unfocusedIndicatorColor = Color.Transparent,
                     disabledIndicatorColor = Color.Transparent
                 ),
                 modifier = Modifier
                     .border(
                         width = 1.dp, color = Color(0xFFC5C5C5),
                         shape = RoundedCornerShape(size = 20.dp)
                     )

                     .padding(1.dp)
                     .width(130.dp)
                     .height(60.dp)
                     .background(
                         color = Color(0xFFF9F9F9),
                         shape = RoundedCornerShape(size = 20.dp)
                     ),

                 )



            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)){

         DropDownMenu()



            }

         }



           Row  {
               Text(
                   modifier = Modifier
                       .height(340.dp)
                       .width(200.dp)
                       .padding(25.dp)
                       .wrapContentSize(Alignment.TopStart),
                   text = "Targeted Currency",
                   style = TextStyle(
                       fontSize = 14.sp,
                       fontFamily = FontFamily.Monospace,
                       fontWeight = FontWeight(600),
                       color = Color(0xFF000000),
                   )
               )


               Spacer(modifier = Modifier.width(1.dp))

               Text(
                   modifier = Modifier
                       // .fillMaxWidth()
                       .height(340.dp)
                       //  .width(200.dp)
                       .padding(horizontal = 5.dp, vertical = 25.dp)
                       .wrapContentSize(Alignment.TopEnd),
                   text = "Targeted Currency",
                   style = TextStyle(
                       fontSize = 14.sp,
                       fontFamily = FontFamily.Monospace,
                       fontWeight = FontWeight(600),
                       color = Color(0xFF000000),
                   )
               )


           }



       }


    }



}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LastBox(){
//
//
//   Box(modifier = Modifier
//       .fillMaxWidth()
//       .height(100.dp)
//   ) {
//        Column (modifier = Modifier
//            .fillMaxSize()
//            .width(100.dp)){
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp, vertical = 500.dp)
//            ) {
//                TextField(
//                    value = "hello", onValueChange = {},
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color(0xFFF9F9F9),
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent
//                    ),
//                    modifier = Modifier
//                        .border(
//                            width = 1.dp, color = Color(0xFFC5C5C5),
//                            shape = RoundedCornerShape(size = 20.dp)
//                        )
//
//                        .padding(1.dp)
//                        .width(130.dp)
//                        .height(60.dp)
//                        .background(
//                            color = Color(0xFFF9F9F9),
//                            shape = RoundedCornerShape(size = 20.dp)
//                        ),
//
//                    )
//
//
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 50.dp)
//                ) {
//
//                    DropDownMenu()
//
//
//                }
//
//
//            }
//        }
//    }
//}
//






































