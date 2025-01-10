package com.example.safe_heaven.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safe_heaven.R
import com.example.safe_heaven.components.HeadingTextComponent
import com.example.safe_heaven.components.MyTextfield
import com.example.safe_heaven.components.NormalTextComponent
import com.example.safe_heaven.ui.theme.BackgroundBlue

@Composable
fun Signupcreen() {
        Surface(
            color = BackgroundBlue,
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundBlue)
                .padding(28.dp)

        ) {Column(
            modifier = Modifier.fillMaxSize()
        ){
            NormalTextComponent(value = stringResource(R.string.hello))
            HeadingTextComponent(value = stringResource(R.string.create_account))
            MyTextfield(labelValue = stringResource(R.string.fName))
        }
        }
    }

@Preview
@Composable
fun DefaultPreviewSUScreen(){
    Signupcreen()
}