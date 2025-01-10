package com.example.safe_heaven.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
        modifier = Modifier.fillMaxWidth().heightIn(min=40.dp),
        style = TextStyle(
            fontSize = 24.sp,
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
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ),
        color = PrimaryTxt,
        textAlign = TextAlign.Center
    )
}
@Composable
fun MyTextfield(labelValue:String){
    val textValue=remember {
        mutableStateOf("")
    }
     OutlinedTextField(
         modifier = Modifier
             .fillMaxWidth()
             .background(
                 shape = RoundedCornerShape(5.dp),
                 color = Color.Transparent
             ),
        label = {Text(labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = FocusedBorder,
            focusedLabelColor = PrimaryTxt,
            focusedContainerColor = focusedTextBox
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
         //OutlinedTextField expects a String for value, not a MutableState<String>
        onValueChange = { newValue->
            textValue.value= newValue
        },
         leadingIcon={
             Icon(painter= painterResource(id = R.drawable.profille), contentDescription = "")
        }
     )
}


