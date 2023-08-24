package com.example.currencyconversionapp.screens.favourite

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


/**
 * CREATES A DIALOGUE THAT CONTAINS OR RETURNS FAVOURITES LIST
 *
 *
 * */

@Composable
fun CustomDialogUI(modifier: Modifier = Modifier) {
    var open by remember {
        mutableStateOf(false
        )
    }

    Column(modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(40.dp),


            onClick = { open = !open }) {
            Text(text = "Open dialogue")
        }

    }

    if (open) {
        FavouriteLayout()
    }



}


@SuppressLint("UnrememberedMutableState")
@Preview(name = "Custom Dialog")
@Composable
fun MyDialogUIPreview() {
    CustomDialogUI()
}
