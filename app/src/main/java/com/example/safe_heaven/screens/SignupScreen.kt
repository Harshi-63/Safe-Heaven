package com.example.safe_heaven.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.safe_heaven.R
import com.example.safe_heaven.components.CheckboxComponent
import com.example.safe_heaven.components.HeadingTextComponent
import com.example.safe_heaven.components.MyPwdField
import com.example.safe_heaven.components.MyTextfield
import com.example.safe_heaven.components.NormalTextComponent
import com.example.safe_heaven.ui.theme.BackgroundBlue


@Composable
fun SignupScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBlue)
            .padding(29.dp)

    ){
       Column(modifier = Modifier
           .fillMaxSize()
           .background(BackgroundBlue))
       {
           NormalTextComponent(value= stringResource(id= R.string.hello))
           HeadingTextComponent(value = stringResource(id=R.string.create_account))
           Spacer(modifier = Modifier.height(20.dp))
           MyTextfield(labelValue = stringResource(id = R.string.fName), painterResource = painterResource(id = R.drawable.profiile))
           MyTextfield(labelValue = stringResource(id = R.string.sName), painterResource = painterResource(id = R.drawable.profiile))
           MyTextfield(labelValue = stringResource(id = R.string.mail), painterResource = painterResource(id = R.drawable.mail))
           MyPwdField(labelValue = stringResource(id=R.string.pwd), painterResource = painterResource(id = R.drawable.pwd))
           CheckboxComponent(value = stringResource(id=R.string.t_and_c))
       }
    }
}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignupScreen()
}