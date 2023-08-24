package com.example.currencyconversionapp.screens.compare

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

// DROP DOW MENU FUNCTION


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(){

    var expanded by remember { (mutableStateOf(false)) }
    val list = listOf<String>("EGP", "USD", "JYP", "KWD", "GBP")
    var selectedItem by remember{ mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if(expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    // Column (modifier = Modifier.padding(20.dp)){
    OutlinedTextField(value = selectedItem,
        onValueChange ={selectedItem = it},
        modifier = Modifier
            .fillMaxWidth()
            .width(100.dp)
            .height(60.dp)
            .background(Color(0xFFF9F9F9))
            .border(
                width = 1.dp, color = Color(0xFFC5C5C5),
                shape = RoundedCornerShape(size = 20.dp)
            )
            .onGloballyPositioned { coordinates ->
                textFieldSize = coordinates.size.toSize()
            },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF9F9F9),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        label = { Text(text = "") },
        trailingIcon = {
            Icon(icon, "", Modifier.clickable { expanded = !expanded })
        }

    )

    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current){textFieldSize.width.toDp()})) {

        list.forEach { label ->
            DropdownMenuItem(text = { Text(text = label, fontSize = 14.sp) }, onClick = {selectedItem = label
                expanded = false })
        }

    }



}

// END OF DROP DOWN MENU FUNCTION

