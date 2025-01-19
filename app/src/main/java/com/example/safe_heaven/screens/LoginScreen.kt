package com.example.safe_heaven.screens

import androidx.activity.compose.BackHandler
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.safe_heaven.R
import com.example.safe_heaven.components.ButtonComponent
import com.example.safe_heaven.components.ClickableLoginTextComponent
import com.example.safe_heaven.components.DividerTextComponent
import com.example.safe_heaven.components.HeadingTextComponent
import com.example.safe_heaven.components.MyPwdField
import com.example.safe_heaven.components.MyTextfield
import com.example.safe_heaven.components.NormalTextComponent
import com.example.safe_heaven.components.UnderlinedTextComponent
import com.example.safe_heaven.data.LoginViewModel
import com.example.safe_heaven.data.UIEvents
import com.example.safe_heaven.navigation.SHRouter
import com.example.safe_heaven.navigation.Screen
import com.example.safe_heaven.ui.theme.BackgroundBlue

@Composable
fun LoginScreen(loginViewModel: LoginViewModel=viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBlue)
            .padding(29.dp)
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundBlue)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            NormalTextComponent(value = stringResource(R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.welcome_back))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextfield(
                labelValue = stringResource(id = R.string.mail),
                painterResource = painterResource(id = R.drawable.mail),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvents.EmailChanges(it))
                },
                errorStatus = loginViewModel.registrationUIState.value.emailError
            )
            MyPwdField(
                labelValue = stringResource(id = R.string.pwd),
                painterResource = painterResource(id = R.drawable.pwd),
                onTextSelected = {
                    loginViewModel.onEvent(UIEvents.PasswordChanges(it))
                },
                errorStatus = loginViewModel.registrationUIState.value.passwordError
            )
            Spacer(modifier = Modifier.height(10.dp))
            UnderlinedTextComponent(value = stringResource(R.string.forgot_pwd))
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login), onButtonClicked = { loginViewModel.onEvent(UIEvents.RegisterButtonClicked) })
            Spacer(modifier = Modifier.height(50.dp))
            DividerTextComponent()
            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                SHRouter.navigateTo(Screen.SignUpScreen)
            })
        }
    }
    BackHandler {
        SHRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen()
}