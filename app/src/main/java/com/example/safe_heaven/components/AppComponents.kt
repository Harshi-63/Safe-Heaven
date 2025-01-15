package com.example.safe_heaven.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.safe_heaven.R
import com.example.safe_heaven.ui.theme.FocusedBorder
import com.example.safe_heaven.ui.theme.PlaceholderTxt
import com.example.safe_heaven.ui.theme.PrimaryTxt
import com.example.safe_heaven.ui.theme.SecondaryTxt
import com.example.safe_heaven.ui.theme.focusedTextBox
import androidx.compose.material3.Text as Text1

@Composable
fun NormalTextComponent(value: String){
    Text1(
        text=value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min=40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = SecondaryTxt,
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingTextComponent(value: String){
    Text1(
        text=value,
        modifier = Modifier.fillMaxWidth().heightIn(),
        style = TextStyle(
            fontSize = 26.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold

        ),
        color = PrimaryTxt,
        textAlign = TextAlign.Center
    )
}
@Composable
fun MyTextfield(labelValue:String,painterResource:Painter){
    val textValue=remember {
        mutableStateOf("")
    }
     OutlinedTextField(
         modifier = Modifier
             .fillMaxWidth()
             .background(
                 shape = RoundedCornerShape(10.dp),
                 color = Color.Transparent
             ),
        label = {Text(labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = FocusedBorder,
            focusedLabelColor = PrimaryTxt,
            focusedContainerColor = focusedTextBox,
            unfocusedContainerColor = Color.White
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
         //OutlinedTextField expects a String for value, not a MutableState<String>
        onValueChange = { newValue->
            textValue.value= newValue
        },
         leadingIcon={
             Icon(painter= painterResource, contentDescription = "")
        }
     )
}
@Composable
fun MyPwdField(labelValue: String, painterResource: Painter) {
    val pwd = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.Transparent
            ),
        label = { Text(labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = FocusedBorder,
            focusedLabelColor = PrimaryTxt,
            focusedContainerColor = focusedTextBox,
            unfocusedContainerColor = Color.White
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = pwd.value,
        onValueChange = { newValue -> pwd.value = newValue },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val descriptor = if (passwordVisible.value) {
                stringResource(R.string.hide_pwd)
            } else {
                stringResource(R.string.show_pwd)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = descriptor)
            }
        },
        visualTransformation = if (passwordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}
@Composable
fun CheckboxComponent(value: String){
    Row (
        modifier = Modifier.fillMaxWidth().heightIn(56.dp).padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val checkedState= remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value!= checkedState.value
        })
        NormalTextComponent(value)
    }
}

