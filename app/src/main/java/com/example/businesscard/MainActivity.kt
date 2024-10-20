package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background

                )

                {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard( modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier=Modifier.fillMaxSize()

    ){
        Column(
            horizontalAlignment =Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            val image = painterResource(R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier= Modifier
                    .size(200.dp)
                    ,
                contentScale= ContentScale.Crop

            )
           Text(
               text = stringResource(R.string.name),
               style = MaterialTheme.typography.headlineMedium.copy(
                   fontWeight = FontWeight.Bold,

               ),
               modifier = Modifier.padding(bottom = 8.dp)

           )
           Text(
               text= stringResource(R.string.title),
               style = MaterialTheme.typography.bodyLarge.copy(
                   color = Color.Gray
               ),
               modifier = Modifier.padding(bottom = 32.dp)

           )
            Spacer(modifier = Modifier.height(100.dp))



            BusinessCardInfo(icon = R.drawable.phone_solid_24__1_, contactText = stringResource(R.string.telephone))
            BusinessCardInfo(icon=R.drawable.instagram_logo_24__3_, contactText = stringResource(R.string.reseau_social))
            BusinessCardInfo(icon = R.drawable.envelope_regular_24, contactText = stringResource(R.string.email) )

        }


    }
}

@Composable
fun BusinessCardInfo(icon:Int,contactText:String){
    Row (
        modifier = Modifier

            .width(200.dp)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = contactText, style = MaterialTheme.typography.bodyMedium)
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}